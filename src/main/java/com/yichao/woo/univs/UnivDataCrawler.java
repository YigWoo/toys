package com.yichao.woo.univs;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClients;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Get university Data From Renren
 */
public class UnivDataCrawler {
    private File provinceSql = new File("province.sql");
    private File collegeSql = new File("college.sql");
    private File departmentSql = new File("department.sql");
    private File dormSql = new File("dorm.sql");
    public static final String GET_DEPT = "http://www.renren.com/GetDep.do?id=";
    public static final String GET_DORM = "http://www.renren.com/GetDorm.do?id=";
    public static final String ALL_UNIVS = "http://s.xnimg.cn/a13819/allunivlist.js";

    public UnivDataCrawler() {
    }

    public void start() throws IOException {
        String cnUnivs = getCnUnivsJsonString();
        List<Province> provinces = getProvinces(cnUnivs);
        for (Province province : provinces) {
            String unicodeName = province.getName();
            province.setName(convertFromHex(unicodeName));
        }

        for (Province province : provinces) {
            List<Univ> univs = province.getUnivs();
            String optionRegex = "<option[^>]*>([^<]*)</option>";
            for (Univ univ : univs) {
                String id = univ.getId();

                HttpEntity httpEntity1 = issueHttpRequest(GET_DEPT + id);
                String responseString1 = getResponseString(httpEntity1);
                Pattern pattern = Pattern.compile(optionRegex);
                Matcher matcher = pattern.matcher(responseString1);
                while (matcher.find()) {
                    String uDepartmentName = matcher.group(1);
                    String departmentName = convertFromDec(uDepartmentName);
                    univ.getDepartments().add(departmentName);
                }

                HttpEntity httpEntity2 = issueHttpRequest(GET_DORM + id);
                String responseString2 = getResponseString(httpEntity2);
                Matcher matcher1 = pattern.matcher(responseString2);
                while (matcher1.find()) {
                    String uDormName = matcher1.group(1);
                    String dormName = convertFromDec(uDormName);
                    univ.getDorms().add(dormName);
                }
            }

            for (Univ univ : univs) {
                univ.getDepartments().remove(0);
                univ.getDorms().remove(0);
            }

            Path univsOfOneProvince = Paths.get(province.getName() + ".txt");
            BufferedWriter writer = Files.newBufferedWriter(univsOfOneProvince, Charset.forName("UTF-8"));
            writer.write(province.getId() + " " + province.getName() + "\r\n");
            writer.write("\r\n");
            for (Univ univ : province.getUnivs()) {
                writer.write(univ.getId() + " " + univ.getName() + "\r\n\r\n");

                writer.write("院系：\r\n");
                for (String dept : univ.getDepartments()) {
                    writer.write(dept + "\r\n");
                }

                writer.write("\r\n寝室：\r\n");
                for (String dorm : univ.getDorms()) {
                    writer.write(dorm + "\r\n");
                }
                writer.write("\r\n\r\n");
            }
            writer.close();
        }

        System.out.println("Data Ready");

    }

    private String convertFromDec(String code) {
        StringBuffer sb = new StringBuffer(code);
        int startPos;
        int endPos;
        while ((startPos = sb.indexOf("&#")) > -1) {
            endPos = sb.indexOf(";");
            String tmp = sb.substring(startPos + 2, endPos);
            sb.replace(startPos, endPos + 1, Character.toString((char) Integer
                    .parseInt(tmp, 10)));
        }
        return code = sb.toString();
    }

    private String convertFromHex(String code) {
        StringBuffer sb = new StringBuffer(code);
        int pos;
        while ((pos = sb.indexOf("\\u")) > -1) {
            String tmp = sb.substring(pos, pos + 6);
            sb.replace(pos, pos + 6, Character.toString((char) Integer
                    .parseInt(tmp.substring(2), 16)));
        }
        return code = sb.toString();
    }


    private void writeCnUnivsToText(String cnUnivs) throws IOException {
        String[] strings = cnUnivs.split("}");
        Path path = Paths.get("allUniv.txt");
        BufferedWriter bufferedWriter = Files.newBufferedWriter(path, Charset.forName("UTF-8"));
        for (String string : strings) {
            bufferedWriter.write(string);
            bufferedWriter.write("}");
            bufferedWriter.write("\r\n");
        }
        bufferedWriter.close();
    }

    private List<Province> getProvinces(String cnUnivs) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, Province.class);
        return objectMapper.readValue(cnUnivs, type);
    }

    private String getCnUnivsJsonString() throws IOException {
        HttpEntity httpEntity = issueHttpRequest(ALL_UNIVS);
        String responseString = getResponseString(httpEntity);
        String cnUnivs = getCnUnivs(responseString);
        cnUnivs = cnUnivs.substring(8);
        return cnUnivs;
    }

    private String getCnUnivs(String responseString) {
        String allUinvRegex = "\"provs\":(.*?)]}";
        Pattern pattern = Pattern.compile(allUinvRegex);
        Matcher matcher = pattern.matcher(responseString);
        matcher.find();
        return matcher.group(0);
    }

    private String getResponseString(HttpEntity httpEntity) throws IOException {
        ContentType contentType = ContentType.getOrDefault(httpEntity);
        Reader reader = new InputStreamReader(httpEntity.getContent(), Charset.forName("UTF-8"));
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        String result = "";
        while ((line = bufferedReader.readLine()) != null) {
            result += line;
        }
        return result;
    }

    private HttpEntity issueHttpRequest(String url) throws IOException {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        // 这个 Cookie 值可能需要改动才能够从人人爬到数据。没有这个 Cookie，拿到的是首页的 html 文档
        httpGet.setHeader("Cookie", "Cookie: anonymid=hz69qrm3-8j3kgb; _r01_=1; JSESSIONID=abc0ZuMsiOs7t-QCUcLGu; depovince=GW; XNESSESSIONID=e71b1dc153f0; wp=0; jebecookies=2fe87010-a7df-4631-b681-d7a9105b59bd|||||; ick_login=7386442e-00ab-4548-a2eb-88226ca710bf; _de=B7F46AAA715F528B5BF7EAB63017E04A; p=806dfd7f8ba7025b101e5ea89d3258252; ap=247748802; first_login_flag=1; t=50085a807668da0514e80f8f39dab6822; societyguester=50085a807668da0514e80f8f39dab6822; id=247748802; xnsid=bf40569b; loginfrom=syshome; ln_uact=tmac1ro@163.com; ln_hurl=http://hdn.xnimg.cn/photos/hdn121/20140622/0015/main_HkP8_5418000014db1986.jpg; WebOnLineNotice_247748802=1; ver=rewrite");
        HttpResponse response = httpClient.execute(httpGet);
        return response.getEntity();
    }

    public static void main(String[] args) throws IOException {
        UnivDataCrawler crawler = new UnivDataCrawler();
        crawler.start();
    }
}

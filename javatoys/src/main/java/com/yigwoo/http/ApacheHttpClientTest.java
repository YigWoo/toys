package com.yigwoo.http;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wuyichao on 2017/4/13.
 */
public class ApacheHttpClientTest {

    public static void main(String[] args) throws IOException {


        SSLContext sslContext = SSLContexts.createSystemDefault();

        SSLConnectionSocketFactory factory = new SSLConnectionSocketFactory(sslContext);


        CloseableHttpClient closeableHttpClient = HttpClients.custom()
                .setSSLSocketFactory(factory)
                .build();

        HttpGet httpGet = new HttpGet("https://www.baidu.com");

        CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpGet);

        HttpEntity entity = closeableHttpResponse.getEntity();
        InputStream content = entity.getContent();
        String s = IOUtils.toString(content, "UTF-8");
        System.out.println(s);
    }
}

package com.yichao.woo.nio;

import java.io.*;

public class InputStreamExp {
    public static void main(String[] args) throws IOException {
        byte[] bytes = {72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100};

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        Reader reader = new InputStreamReader(byteArrayInputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String s = bufferedReader.readLine();
        System.out.println(s);
    }


}

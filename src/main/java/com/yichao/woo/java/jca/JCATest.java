package com.yichao.woo.java.jca;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Created by Yichao-Woo.
 */
public class JCATest {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
        KeyGenerator des = KeyGenerator.getInstance("DES");
        des.init(56);
        SecretKey secretKey = des.generateKey();

        Mac hmacSHA256 = Mac.getInstance("HmacSHA256");
        hmacSHA256.init(secretKey);
        byte[] bytes = hmacSHA256.doFinal("Hello Crypto".getBytes());
        System.out.println(Base64.getEncoder().encodeToString(bytes));
        System.out.println(new String(Base64.getEncoder().encode(bytes)));

        System.out.println(hmacSHA256);
        MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
        System.out.println(sha256);
    }
}

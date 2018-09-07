package com.yigwoo.java.classloader;

/**
 * Created by Yichao-Woo.
 */
public class StaticTest {

    static {
        i = 0;
//        System.out.println(i); //won't compile
    }

    static int i = 1;
}

package com.yigwoo.java;

/**
 * Created by Yichao-Woo.
 */
class ClassicSingleton {
    private static ClassicSingleton instance = null;

    private ClassicSingleton() {
        // Exists only to defeat instantiation.
    }

    synchronized static ClassicSingleton getInstance() {
        long start = System.currentTimeMillis();
        if (instance == null) {
            Thread.yield(); // advice the thread to give up cpu control
            instance = new ClassicSingleton();
        }
        System.out.println(System.currentTimeMillis() - start);
        return instance;
    }
}
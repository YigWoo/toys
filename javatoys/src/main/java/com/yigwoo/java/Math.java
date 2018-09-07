package com.yigwoo.java;

/**
 * Created by Yichao-Woo.
 */
public class Math {

    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = math(a, b) / 10;

        BarrierExample barrierExample = new BarrierExample();
    }

    private static int math(int a, int b) {
        return (a + b) * 10;
    }
}

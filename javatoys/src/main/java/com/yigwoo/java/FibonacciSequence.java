package com.yigwoo.java;

public class FibonacciSequence {
    public static long fibIter(int n) {
        if (n == 1 || n == 2) {
            return 1L;
        }

        long f1 = 1;
        long f2 = 1;
        long mid;
        for (int i = 2; i < n; i++) {
            mid = f2;
            f2 = f1 + f2;
            f1 = mid;
        }
        System.out.println(f2);
        return f2;
    }

    public static long fibRecursive(int n) {
        return 0L;
    }


    public static void main(String[] args) {
        System.out.println(fibIter(10));
    }
}

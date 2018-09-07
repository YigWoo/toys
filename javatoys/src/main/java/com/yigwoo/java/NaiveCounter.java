package com.yigwoo.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuyichao on 2017/4/18.
 */
public class NaiveCounter {

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        final Integer[] counter = {0};

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter[0]++;
                }
            });
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(counter[0]);
    }
}

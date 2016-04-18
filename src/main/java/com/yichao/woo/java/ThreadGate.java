package com.yichao.woo.java;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Yichao-Woo.
 */
public class ThreadGate {

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            threads.add(new HelloWorldRunnable(i, countDownLatch));
        }

        threads.forEach(Thread::start);
    }

    static class HelloWorldRunnable extends Thread {
        private int i;
        private CountDownLatch latch;

        HelloWorldRunnable(int i, CountDownLatch latch) {
            this.i = i;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.printf("count down of %d\n", i);
            latch.countDown();
            try {
                latch.await(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%d: hello world\n", i);
        }
    }
}

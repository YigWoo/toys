package com.yichao.woo.jvm;

/**
 * Created by Yichao-Woo.
 */
public class VolatileTest {

    private static volatile int race = 0;

    private static void increase() {
        race++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[20];

        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    increase();
                }
            });
            threads[i].start();
        }

        for (int i = 0; i < 20; i++) {
            if (threads[i].isAlive()) {
                Thread.sleep(5000);
            }
        }

        System.out.println(race);
    }
}


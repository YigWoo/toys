package com.yichao.woo.java.concurrent;

/**
 * Created by Yichao-Woo.
 */
public class VolatileAsCounter {

    private volatile int counter;

    private VolatileAsCounter() {
        this.counter = 0;
    }

    private void increment() {
        counter++;
    }

    private int counter() {
        return counter;
    }

    public static void main(String[] args) throws InterruptedException {

        VolatileAsCounter counter = new VolatileAsCounter();

        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            });
            thread.start();
            threads[i] = thread;
        }

        for (int i = 0; i < 100; i++) {
            threads[i].join();
        }

        System.out.println(counter.counter());
    }
}

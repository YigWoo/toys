package com.yichao.woo.java.locks;

/**
 * Created by Yichao-Woo.
 */
public class IntrinsicLockInterruptTest {

    private static final Object lock1 = new Object();

    // illustrate the case when a thread is waiting for intrinsic lock
    // it won't be interrupted and keep alive
    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                //noinspection InfiniteLoopStatement,StatementWithEmptyBody
                while (true) {
                }
            }
        });

        thread1.start();

        Thread thread2 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("get lock1");
            }
        });

        thread2.start();

        Thread.sleep(1000);

        thread2.interrupt();

        Thread.sleep(5000);

        for (int i = 0; i < 10000; i++) {
            System.out.println(thread2.isAlive());
        }
    }
}

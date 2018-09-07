package com.yigwoo.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer {
    private final Lock lock = new ReentrantLock();
    final Condition notFull  = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[100];
    int putptr, takeptr, count;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length)
                notFull.await();
            items[putptr] = x;
            if (++putptr == items.length) putptr = 0;
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0)
                notEmpty.await();
            Object x = items[takeptr];
            if (++takeptr == items.length) takeptr = 0;
            --count;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        BoundedBuffer buffer = new BoundedBuffer();

        for (int i = 0; i < 5; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < 100; j++) {
                    try {
                        buffer.put("this is put " + j + Thread.currentThread().toString());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("put finished");
            });
        }

        AtomicInteger count = new AtomicInteger(0);

        for (int i = 0; i < 4; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < 125; j++) {
                    try {
                        String take = (String) buffer.take();
//                        System.out.println(take);
                        count.incrementAndGet();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("take finished");
            });
        }

        Thread.sleep(5000);
        System.out.println(count);
    }

}
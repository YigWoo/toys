package com.yichao.woo.java;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Yichao-Woo.
 */
public class BarrierExample {

    protected BarrierExample() {
    }

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(1);

        barrier.await();

        System.out.println("Barrier Passed");
    }
}

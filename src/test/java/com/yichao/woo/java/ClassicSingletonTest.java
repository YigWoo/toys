package com.yichao.woo.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Yichao-Woo.
 */
public class ClassicSingletonTest {

    @Test
    public void testGetInstance() throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        ArrayList<Future<ClassicSingleton>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<ClassicSingleton> future = executorService.submit(new GetClassicSingletonWork());
            futures.add(future);
        }

        for (Future<ClassicSingleton> future : futures) {
            ClassicSingleton classicSingleton = future.get();
//            System.out.println(classicSingleton.hashCode());
        }


    }

    static class GetClassicSingletonWork implements Callable<ClassicSingleton> {
        @Override
        public ClassicSingleton call() throws Exception {
            return ClassicSingleton.getInstance();
        }
    }

}
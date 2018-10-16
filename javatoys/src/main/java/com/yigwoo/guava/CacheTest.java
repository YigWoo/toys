package com.yigwoo.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheStats;
import com.google.common.cache.LoadingCache;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CacheTest {

    public static final String KEY = "key";

    public static void main(String[] args) {
        LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder()
                .maximumSize(100)
                .expireAfterAccess(5, TimeUnit.SECONDS)
                .recordStats()
                .removalListener(notification -> System.out.println(notification.wasEvicted()))
                .build(new CacheLoader<String, String>() {
                           @Override
                           public String load(String key) {
                               System.out.println(String.format("loading cache key %s", key));
                               return String.valueOf(new Random(key.hashCode()).nextLong());
                           }
                       }
                );

        try {
            for (int i = 0; i < 20; i++) {
                String s = loadingCache.get(KEY);
                System.out.println(s);
                Thread.sleep(1000);
            }
            System.out.println(loadingCache.stats());
            System.out.println(loadingCache.stats().hitRate());
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

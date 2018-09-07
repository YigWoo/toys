package com.yigwoo.ratelimiter.v1;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Yichao-Woo.
 */
public class LuaRateLimiter {
    private JedisPool jedisPool;
    private long intervalInMills;
    private long limit;

    // because we'll use intervalPerPermit to calculate time left shift padding by mod
    // the calculation result will be a floating number if intervalPerPermit is
    // a floating number. So I use integer here, it will loose some precision, but I think
    // it's kind of negligible
    private long intervalPerPermit;
    private String scriptSha1;

    public LuaRateLimiter() throws IOException {
        jedisPool = new JedisPool("192.168.38.3", 6379);
        intervalInMills = 10000;
        limit = 3;
        intervalPerPermit = intervalInMills / limit;

        try (Jedis jedis = jedisPool.getResource()) {
            Path path = Paths.get("rate_limiter.lua");
            byte[] scriptBytes = Files.readAllBytes(path);
            String script = new String(scriptBytes);
            scriptSha1 = jedis.scriptLoad(script);
            System.out.println(scriptSha1);
        }
    }

    private String genKey(String userId) {
        return "rate:limiter:" + intervalInMills + ":" + limit + ":" + userId;
    }

    public boolean access(String user) {
        String key = genKey(user);

        try (Jedis jedis = jedisPool.getResource()) {
            Object result = jedis.evalsha(scriptSha1, 1, key, String.valueOf(intervalPerPermit),
                    String.valueOf(System.currentTimeMillis()), String.valueOf(limit), String.valueOf(intervalInMills));
            System.out.println(result);
            return true;
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        LuaRateLimiter rateLimiter = new LuaRateLimiter();

        for (int i = 0; i < 3; i++) {
            boolean yigwoo = rateLimiter.access("com/yigwoo");
            System.out.println(yigwoo);
        }

        boolean yigwoo = rateLimiter.access("com/yigwoo");
        System.out.println(yigwoo);

        Thread.sleep(7000);

        boolean yigwoo1 = rateLimiter.access("com/yigwoo");
        System.out.println(yigwoo1);
    }
}

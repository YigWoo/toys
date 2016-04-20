package com.yichao.woo.ratelimiter;

import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Yichao-Woo.
 */
public class LuaRateLimiter {

    public static void main(String[] args) throws IOException {
        Jedis jedis = new Jedis("192.168.38.3", 6379);

        Path path = Paths.get("rate_limiter.lua");
        byte[] scriptBytes = Files.readAllBytes(path);
        String script = new String(scriptBytes);
        String sha1 = jedis.scriptLoad(script);

        System.out.println();

        Object evalSha = jedis.evalsha(sha1);
        System.out.println(evalSha);
    }
}

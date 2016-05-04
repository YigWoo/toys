package com.yichao.woo.ratelimiter.v2;


import com.google.common.base.Preconditions;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public final class LuaRateLimiter {
    private JedisPool       jedisPool;
    private String          scriptSha1;
    private RateLimitPolicy policy;

    private LuaRateLimiter() {
        jedisPool = new JedisPool("192.168.70.3", 6379);
    }

    public final boolean access(final String identity) {
        Preconditions.checkNotNull(jedisPool, "Redis not initialized");
        Preconditions.checkNotNull(policy, "Policy not initialized");
        Preconditions.checkArgument(StringUtils.isNotBlank(scriptSha1), "Sha1 not initialized");

        String key = policy.genBucketKey(identity);

        try (Jedis jedis = jedisPool.getResource()) {
            long result = (long) jedis.evalsha(scriptSha1, 1, key,
                    String.valueOf(policy.getIntervalPerPermit()),
                    String.valueOf(System.currentTimeMillis()),
                    String.valueOf(policy.getMaxBurstTokens()),
                    String.valueOf(policy.getCapacity()),
                    String.valueOf(policy.getIntervalInMills()));

            return result == 1L;
        }
    }

    static String read(String luaScriptPath) throws IOException {
        Path path = Paths.get(luaScriptPath);
        byte[] scriptBytes = Files.readAllBytes(path);
        return new String(scriptBytes);
    }

    public static class Builder {
        private String luaScript;

        public Builder(String luaScriptPath) throws IOException {
            luaScript = read(luaScriptPath);
        }


        public LuaRateLimiter newLuaRateLimiter(RateLimitPolicy policy) {
            Preconditions.checkNotNull(policy);
            LuaRateLimiter limiter = new LuaRateLimiter();
            limiter.policy = policy;
            try (Jedis jedis = limiter.jedisPool.getResource()) {
                limiter.scriptSha1 = jedis.scriptLoad(luaScript);
            }
            return limiter;
        }
    }
}
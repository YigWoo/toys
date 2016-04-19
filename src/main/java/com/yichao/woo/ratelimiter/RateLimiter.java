package com.yichao.woo.ratelimiter;

import lombok.Getter;
import lombok.Setter;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yichao-Woo.
 */
public class RateLimiter {

    private JedisPool jedisPool;

    // interval in seconds
    private long interval;
    private long limit;

    public RateLimiter() {
        jedisPool = new JedisPool("192.168.38.3", 6379);
        interval = 10;
        limit = 3;
    }

    // 单线程操作下才能保证正确性
    // 需要这些操作原子性的话，最好使用 redis 的 lua script
    public boolean access(String userId) {
        String key = genKey(userId);

        try (Jedis jedis = jedisPool.getResource()) {
            Map<String, String> counter = jedis.hgetAll(key);

            if (counter.size() == 0) {
                TokenBucket tokenBucket = new TokenBucket(System.currentTimeMillis() / 1000, limit - 1, limit);
                jedis.hmset(key, tokenBucket.toHash());

                // grant access
                return true;

            } else {
                TokenBucket tokenBucket = TokenBucket.fromHash(counter);

                long lastRefillTime = tokenBucket.getLastRefillTime();
                long refillTime = System.currentTimeMillis() / 1000;
                long intervalSinceLast = refillTime - lastRefillTime;

                long currentTokenRemaining;
                if (intervalSinceLast > interval) {
                    currentTokenRemaining = limit;
                } else {
                    // TODO 计算 stableIntervalMicros，参考 Guava 的 RateLimiter
                    long grantedTokens = (long) (limit * (intervalSinceLast * 1.0 / interval));
                    currentTokenRemaining = Math.min(grantedTokens + tokenBucket.getTokensRemaining(), tokenBucket.getLimit());
                }

                tokenBucket.setLastRefillTime(refillTime);
                if (currentTokenRemaining == 0) {
                    tokenBucket.setTokensRemaining(currentTokenRemaining);
                    jedis.hmset(key, tokenBucket.toHash());
                    return false;
                } else {
                    tokenBucket.setTokensRemaining(currentTokenRemaining - 1);
                    jedis.hmset(key, tokenBucket.toHash());
                    return true;
                }
            }
        }
    }

    private String genKey(String userId) {
        return "rate:limiter:" + interval + ":" + limit + ":" + userId;
    }

    @Getter
    @Setter
    public static class TokenBucket {
        private long lastRefillTime;
        private long tokensRemaining;
        private long limit;

        public TokenBucket(long lastRefillTime, long tokensRemaining, long limit) {
            this.lastRefillTime = lastRefillTime;
            this.tokensRemaining = tokensRemaining;
            this.limit = limit;
        }

        public static TokenBucket fromHash(Map<String, String> hash) {
            long lastRefillTime = Long.parseLong(hash.get("lastRefillTime"));
            int tokensRemaining = Integer.parseInt(hash.get("tokensRemaining"));
            int limit = Integer.parseInt(hash.get("limit"));
            return new TokenBucket(lastRefillTime, tokensRemaining, limit);
        }

        public Map<String, String> toHash() {
            Map<String, String> hash = new HashMap<>();
            hash.put("lastRefillTime", String.valueOf(lastRefillTime));
            hash.put("tokensRemaining", String.valueOf(tokensRemaining));
            hash.put("limit", String.valueOf(limit));
            return hash;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = new RateLimiter();

        for (int i = 0; i < 3; i++) {
            boolean yigwoo = rateLimiter.access("yigwoo");
            System.out.println(yigwoo);
        }

        boolean yigwoo = rateLimiter.access("yigwoo");
        System.out.println(yigwoo);

        Thread.sleep(3500);

        boolean yigwoo1 = rateLimiter.access("yigwoo");
        System.out.println(yigwoo1);
    }
}

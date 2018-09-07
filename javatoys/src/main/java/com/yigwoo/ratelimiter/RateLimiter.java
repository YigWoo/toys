package com.yigwoo.ratelimiter;

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

    private long intervalInMills;
    private long limit;
    private double intervalPerPermit;

    public RateLimiter() {
        jedisPool = new JedisPool("192.168.38.3", 6379);
        intervalInMills = 10000;
        limit = 3;
        intervalPerPermit = intervalInMills * 1.0 / limit;
    }

    // 单线程操作下才能保证正确性
    // 需要这些操作原子性的话，最好使用 redis 的 lua script
    public boolean access(String userId) {

        String key = genKey(userId);

        try (Jedis jedis = jedisPool.getResource()) {
            Map<String, String> counter = jedis.hgetAll(key);

            if (counter.size() == 0) {
                TokenBucket tokenBucket = new TokenBucket(System.currentTimeMillis(), limit - 1);
                jedis.hmset(key, tokenBucket.toHash());
                return true;
            } else {
                TokenBucket tokenBucket = TokenBucket.fromHash(counter);

                long lastRefillTime = tokenBucket.getLastRefillTime();
                long refillTime = System.currentTimeMillis();
                long intervalSinceLast = refillTime - lastRefillTime;

                long currentTokensRemaining;
                if (intervalSinceLast > intervalInMills) {
                    currentTokensRemaining = limit;
                } else {
                    long grantedTokens = (long) (intervalSinceLast / intervalPerPermit);
                    System.out.println(grantedTokens);
                    currentTokensRemaining = Math.min(grantedTokens + tokenBucket.getTokensRemaining(), limit);
                }

                tokenBucket.setLastRefillTime(refillTime);
                assert currentTokensRemaining >= 0;
                if (currentTokensRemaining == 0) {
                    tokenBucket.setTokensRemaining(currentTokensRemaining);
                    jedis.hmset(key, tokenBucket.toHash());
                    return false;
                } else {
                    tokenBucket.setTokensRemaining(currentTokensRemaining - 1);
                    jedis.hmset(key, tokenBucket.toHash());
                    return true;
                }
            }
        }
    }

    private String genKey(String userId) {
        return "rate:limiter:" + intervalInMills + ":" + limit + ":" + userId;
    }

    @Getter
    @Setter
    public static class TokenBucket {
        private long lastRefillTime;
        private long tokensRemaining;

        public TokenBucket(long lastRefillTime, long tokensRemaining) {
            this.lastRefillTime = lastRefillTime;
            this.tokensRemaining = tokensRemaining;
        }

        public static TokenBucket fromHash(Map<String, String> hash) {
            long lastRefillTime = Long.parseLong(hash.get("lastRefillTime"));
            int tokensRemaining = Integer.parseInt(hash.get("tokensRemaining"));
            return new TokenBucket(lastRefillTime, tokensRemaining);
        }

        public Map<String, String> toHash() {
            Map<String, String> hash = new HashMap<>();
            hash.put("lastRefillTime", String.valueOf(lastRefillTime));
            hash.put("tokensRemaining", String.valueOf(tokensRemaining));
            return hash;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = new RateLimiter();

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

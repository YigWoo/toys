package com.yichao.woo.ratelimiter.v2;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class LuaRateLimiterTest {

    private LuaRateLimiter  sut;
    private JedisPool jedisPool;
    private RateLimitPolicy policy;

    @Before
    public void setUp() throws Exception {
        // assume working directory when running is project root
        jedisPool = new JedisPool("127.0.0.1", 6379);
        policy = new PerUserRateLimitPolicy(10, 20000, 10000);
        LuaRateLimiter.Builder builder = new LuaRateLimiter.Builder("rate_limiter.lua");
        sut = builder.newLuaRateLimiter(policy);
    }

    @After
    public void tearDown() throws Exception {
        try (Jedis jedis = jedisPool.getResource()){
            jedis.del(policy.genBucketKey("yigwoo"));
            jedis.del(policy.genBucketKey("chao"));
        }
    }

    @SuppressWarnings("MethodWithMultipleLoops")
    @Test
    @Ignore
    public void access() throws Exception {
        // the test must run with redis, so during unit test phase of package, ignore it
        for (int j = 0; j < 3; j++) {

            for (int i = 0; i < 10; i++) {
                boolean result = sut.access("yigwoo");
                if (i < 5) {
                    assertThat(result).isTrue();
                } else {
                    assertThat(result).isFalse();
                }
            }
            System.out.println("first phase");

            for (int i = 0; i < 5; i++) {
                boolean chao = sut.access("chao");
                assertThat(chao).isTrue();
            }

            Thread.sleep(5000);

            for (int i = 0; i < 3; i++) {
                boolean yigwoo = sut.access("yigwoo");
                if (i < 2) {
                    assertThat(yigwoo).isTrue();
                } else {
                    assertThat(yigwoo).isFalse();
                }
            }
            tearDown();
        }
    }
}

package com.yigwoo.java;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by Yichao-Woo.
 */
abstract class JedisOperation<T> {

    private JedisPool jedisPool = new JedisPool("localhost");

    protected abstract T jedisOp(Jedis jedis);

    T doOp() {
        try (Jedis jedis = jedisPool.getResource()) {
            System.out.println("1");
            return jedisOp(jedis);
        }
    }
}

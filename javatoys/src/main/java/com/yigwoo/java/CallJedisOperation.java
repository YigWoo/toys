package com.yigwoo.java;

import redis.clients.jedis.Jedis;

/**
 * Created by Yichao-Woo.
 */
public class CallJedisOperation {

    public static void main(String[] args) {

        new JedisOperation<Long>() {
            @Override
            protected Long jedisOp(Jedis jedis) {
                return jedis.del("key");
            }
        }.doOp();

        new JedisOperation<Long>() {
            @Override
            protected Long jedisOp(Jedis jedis) {
                return jedis.rpush("key", "element");
            }
        }.doOp();

    }
}

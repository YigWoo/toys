package com.yichao.woo.ratelimiter.v2;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class RateLimitPolicy {
    private final long intervalInMills;
    private final long capacity;
    // max tokens saved if user don't use the bucket for a long time
    // equals to intervalPerPermit * maxBurstTime
    private final long maxBurstTokens;

    // because we'll use intervalPerPermit to calculate time left shift padding by mod
    // the calculation result will be a floating number if intervalPerPermit is
    // a floating number. So I use integer here, it will loose some precision, but I think
    // it's kind of negligible
    private final long intervalPerPermit;

    RateLimitPolicy(long capacity, long intervalInMills, long maxBurstTime) {
        this.capacity = capacity;
        this.intervalInMills = intervalInMills;
        intervalPerPermit = intervalInMills / capacity;
        maxBurstTokens = maxBurstTime/intervalPerPermit;
    }

    public abstract String genBucketKey(String identity);

}

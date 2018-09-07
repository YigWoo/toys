package com.yigwoo.ratelimiter.v2;

public class PerUserRateLimitPolicy extends RateLimitPolicy {
    public PerUserRateLimitPolicy(long capacity, long intervalInMills, long maxBurstTime) {
        super(capacity, intervalInMills, maxBurstTime);
    }

    @Override
    public String genBucketKey(String identity) {
        return "rate:limiter:" + getIntervalInMills() + ":" + getCapacity() + ":" + identity;
    }
}

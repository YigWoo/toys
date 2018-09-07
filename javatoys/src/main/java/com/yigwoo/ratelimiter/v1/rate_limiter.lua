local key, intervalPerPermit, refillTime, limit, interval = KEYS[1], tonumber(ARGV[1]), tonumber(ARGV[2]), tonumber(ARGV[3]), tonumber(ARGV[4])
local counter = redis.call('hgetall', key)

if table.maxn(counter) == 0 then
    redis.call('hmset', key, 'lastRefillTime', refillTime, 'tokensRemaining', limit - 1)
    return 1
elseif table.maxn(counter) == 4 then
    local lastRefillTime, tokensRemaining = tonumber(counter[2]), tonumber(counter[4])
    -- check if refillTime larger than lastRefillTime.
    -- if not, it means some other operation later than this call made the call first.
    -- there is no need to refill the tokens.
    local currentTokens
    if refillTime > lastRefillTime then
        local intervalSinceLast = refillTime - lastRefillTime
        if intervalSinceLast > interval then
            currentTokens = limit
            redis.call('hset', key, 'lastRefillTime', refillTime)
        else
            local grantedTokens = math.floor(intervalSinceLast / intervalPerPermit)
            if grantedTokens > 0 then
                -- ajust lastRefillTime, we want shift left the refill time.
                local padMillis = math.fmod(intervalSinceLast, intervalPerPermit)
                redis.call('lpush', 'debug', intervalSinceLast, intervalPerPermit, padMillis)
                redis.call('hset', key, 'lastRefillTime', refillTime - padMillis)
            end
            currentTokens = math.min(grantedTokens + tokensRemaining, limit)
        end

        assert(currentTokens >= 0)
        if currentTokens == 0 then
            -- we didn't consume any keys
            redis.call('hset', key, 'tokensRemaining', currentTokens)
            return 0
        else
            redis.call('hset', key, 'tokensRemaining', currentTokens - 1)
            return 1
        end
    end
else
    error("Size of counter is " .. table.maxn(counter) .. ", Should Be 0 or 4.")
end

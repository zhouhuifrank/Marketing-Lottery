-- KEYS[]存储redis的key参数 ARGV[]存储redis的value
-- redis的api redis.call()
local threadId = redis.call('get',KEYS[1])
if (threadId == ARGV[1]) then
    return redis.call('del',KEYS[1])
end
-- value不匹配直接返回
return 0
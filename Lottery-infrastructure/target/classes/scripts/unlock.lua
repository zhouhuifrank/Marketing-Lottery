--- 实现释放锁的原子性操作
--- KEYS[]数组存放redis的key,ARGV[]数组存放redis的value
local threadId = redis.call("get",KEYS[1]);
if (threadId == ARGV[1]) then
    return redis.call("del",KEYS[1]);
end
return 0;
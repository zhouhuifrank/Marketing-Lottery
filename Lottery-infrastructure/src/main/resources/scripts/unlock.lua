--- 实现释放锁的原子性操作
--- KEYS[]数组存放redis的key,ARGV[]数组存放redis的value
local threadId = 1;

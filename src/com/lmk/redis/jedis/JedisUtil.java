package com.lmk.redis.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public enum JedisUtil {
    INSTANCE;
    private static JedisPool pool;
    static{
        //创建配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        //设置配置
        config.setMaxIdle(2);
        config.setMaxTotal(10);
        config.setMaxWaitMillis(1*1000);
        config.setTestOnBorrow(true);
        //创建jedispool
        pool = new JedisPool(config,"127.0.0.1",6379,1*1000,"admin");
    }
    public Jedis getResource(){
        return pool.getResource();
    }
    public void close(Jedis jedis){
        jedis.close();
    }
}

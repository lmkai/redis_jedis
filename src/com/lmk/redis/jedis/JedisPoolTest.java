package com.lmk.redis.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolTest {
    @Test
    public void test()throws Exception{
        //1 创建jedispool配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        //2 做配置-四个
        config.setMaxIdle(2);
        config.setMaxTotal(8);
        config.setMaxWaitMillis(1*1000);
        config.setTestOnBorrow(true);
        //3 创建jedispool
        JedisPool pool = new JedisPool(config,"127.0.0.1",6379,1*1000,"admin");
        //4 通过jedispool获取连接
        Jedis jedis = pool.getResource();
        //5 执行操作
        jedis.set("mk", "mk");
        System.out.println(jedis.get("mk"));
        // 6 释放连接
        jedis.close();
        // 7 摧毁连接池-如果是真正项目中它应该是一个受spring管理的单例
        pool.destroy();
    }
}

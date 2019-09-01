package com.lmk.redis.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Iterator;

public class JedisOprTest {
    Jedis jedis = JedisUtil.INSTANCE.getResource();
    @Test
    public void testKey()throws Exception{

        //清空数据
        jedis.flushAll();
        //判断是否存在
        System.out.println(jedis.exists("name"));
        System.out.println(jedis.exists("age"));
        System.out.println(jedis.exists("sex"));

        //设置值
        System.out.println(jedis.set("name", "mk"));
        System.out.println(jedis.set("age", "18"));
        System.out.println(jedis.set("sex", "nan"));

        //判断设置后是否存在
        System.out.println(jedis.exists("name"));
        System.out.println(jedis.exists("age"));
        System.out.println(jedis.exists("sex"));

        //获取值
        System.out.println(jedis.get("name"));
        //删除前获取的值
        System.out.println(jedis.get("age"));
        //删除
        System.out.println(jedis.del("age"));
        //删除后获取的值
        System.out.println(jedis.get("age"));

        Iterator<String> iterator = jedis.keys("*").iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            System.out.println(key+"--"+jedis.get(key));
        }
    }
}

package com.lmk.redis.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class JedisTest {
    @Test
    public void testJedis()throws Exception{
        //创建连接,本地
        String host="127.0.0.1";
        //端口号
        int port=6379;
        //连接超时时间
        int timeout=1*1000;
        Jedis jedis = new Jedis(host,port,timeout);
        //设置密码
        jedis.auth("admin");
        //设置值
        jedis.set("lmk", "lmk");
        //打印获取值
        System.out.println(jedis.get("lmk"));
        //关闭连接
        jedis.close();
    }
}

package com.ruan.Lagou.rides;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @Author: ruan
 * Date: 2021/12/12 1:24
 * @Description:
 */
public class test {

    @Autowired
    public StringRedisTemplate redisTemplate;

    @Test
    public void test(){
        redisTemplate.opsForValue().set("test","1234");
    }
}

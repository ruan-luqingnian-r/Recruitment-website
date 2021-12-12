package com.ruan.Lagou;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class LagouApplicationTests {


	@Test
	void contextLoads() {
	}

	@Autowired
	public StringRedisTemplate redisTemplate;

	@Test
	 void test(){
		redisTemplate.opsForValue().set("test","1234");
	}

}

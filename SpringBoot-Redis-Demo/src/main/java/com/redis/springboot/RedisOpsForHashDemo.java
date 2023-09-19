package com.redis.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisOpsForHashDemo {

	public static void main(String[] args) {
		SpringApplication.run(RedisOpsForHashDemo.class, args);
	}

}

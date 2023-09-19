package com.redis.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/*
 * @EnableCaching annotation is mandatory here
 * in order to start caching.
 * 
 */

@SpringBootApplication
@EnableCaching
public class RedisHashRepositoryDemo {

  public static void main(String[] args) {
    SpringApplication.run(RedisHashRepositoryDemo.class, args);
  }

}

package com.redis.springboot.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

/*
 * Bydefault port is 6379. If default port is used then no need of setting RedisStandaloneConfiguration 
 * or properties in application.properties
 * just return new JedisConnectionFactory();
 * 
 * To use another port, explicitly create RedisStandaloneConfiguration() and set host & port.
 * 
 */

@Configuration
public class RedisConfig {

	@Value("${spring.data.redis.host}")
	private String HOST;
	
	@Value("${spring.data.redis.port}")
	private int PORT;
	
	@Value("${spring.data.redis.password}")
	private String PASSWORD;
	
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
		redisStandaloneConfiguration.setHostName(HOST);
		redisStandaloneConfiguration.setPort(PORT);
		redisStandaloneConfiguration.setPassword(PASSWORD);

		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisStandaloneConfiguration);
		return jedisConnectionFactory;
	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
		template.setConnectionFactory(jedisConnectionFactory());
		template.setValueSerializer(new GenericToStringSerializer<>(Object.class));
		return template;
	}

	@Bean
	public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
		return (builder) -> builder
				.withCacheConfiguration("itemCache",
						RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(10)))
				.withCacheConfiguration("studentCache",
						RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(1)));
	}

}

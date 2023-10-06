package com.camel.redis.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.redis.RedisConstants;
import org.springframework.stereotype.Component;

@Component
public class MainRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("file:src/main/resources/inputFolder?noop=true")
				//.log(LoggingLevel.INFO, log, "Headers: ${headers}")
				.convertBodyTo(String.class)
				.setProperty("input", simple("${body}"))
				.log(LoggingLevel.INFO, log, "Input: ${exchangeProperty.input}")
				.setBody(simple("${null}"))
				.setHeader(RedisConstants.COMMAND, constant("GET"))
				.setHeader(RedisConstants.KEY, simple("${headers.CamelFileName}"))
					//.to("spring-redis://dummyhost:0000?connectionFactory=#jedisConnFactory")
					.to("spring-redis://localhost:6379?redisTemplate=#redisTemplate")
					
				.choice()
					.when(simple("${body} == null"))
						.log(LoggingLevel.INFO, log, "No Value received from Redis; Caching for key: ${headers.CamelFileName}")
						.setHeader(RedisConstants.COMMAND, constant("SET"))
						.setHeader(RedisConstants.KEY, simple("${headers.CamelFileName}"))
						.setHeader(RedisConstants.VALUE, simple("${exchangeProperty.input}"))
							//.to("spring-redis://localhost:6379?connectionFactory=#jedisConnFactory")
							.to("spring-redis://localhost:6379?redisTemplate=#redisTemplate")
						.log(LoggingLevel.INFO, log, "Cached Successfully for key: ${headers.CamelFileName}\n")
					.endChoice()
					
					.otherwise()
						.log(LoggingLevel.INFO, log, "Received Redis Response [KEY: ${headers.CamelFileName}, VALUE: ${body}]")
							.to("file:src/main/resources/outputFolder")
						.log(LoggingLevel.INFO, log, "resources/inputFolder File Shifted to resources/outputFolder !!\n")
					.endChoice()
					
				.end();
	}

}

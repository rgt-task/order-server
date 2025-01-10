package com.test.rgt_task.config.rabbitmq;

import org.springframework.boot.context.properties.ConfigurationProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;

@ConfigurationProperties(prefix = "spring.rabbitmq")
@AllArgsConstructor
@Getter
public class RabbitMqProperties {
	private String host;
	private int port;
	private String username;
	private String password;
}





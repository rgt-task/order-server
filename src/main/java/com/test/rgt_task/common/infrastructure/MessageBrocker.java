package com.test.rgt_task.common.infrastructure;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class MessageBrocker {
	private final RabbitTemplate rabbitTemplate;

	@Value("${rabbitmq.exchange.name}")
	private String exchangeName;

	@Value("${rabbitmq.routing.key}")
	private String routingKey;

	public void sendMessage(Object message) {
		rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
	}
}

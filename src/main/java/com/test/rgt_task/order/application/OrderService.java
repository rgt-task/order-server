package com.test.rgt_task.order.application;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.test.rgt_task.common.infrastructure.MessageBrocker;
import com.test.rgt_task.order.application.dtos.OrderCreateParam;
import com.test.rgt_task.order.domain.Order;
import com.test.rgt_task.order.enums.OrderStatus;
import com.test.rgt_task.order.infrastructure.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
	private final OrderRepository orderRepository;
	private final MessageBrocker messageBrocker;

	public Order createOrder(OrderCreateParam orderCreateParam) {

		Order order = Order.builder()
			.status(OrderStatus.WAITING.getDescription())
			.food(orderCreateParam.getFood())
			.quantity(orderCreateParam.getQuantity())
			.build();
		Order savedOrder = orderRepository.save(order);

		//여기에 rabbitmq로 메세지 발송하는 부분
		messageBrocker.sendMessage(savedOrder);

		return savedOrder;
	}

	public List<Order> findAll() {
		return orderRepository.findAll();
	}
}

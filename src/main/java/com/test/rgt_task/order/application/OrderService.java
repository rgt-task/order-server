package com.test.rgt_task.order.application;

import org.springframework.stereotype.Service;

import com.test.rgt_task.order.application.dtos.OrderCreateParam;
import com.test.rgt_task.order.domain.Order;
import com.test.rgt_task.order.infrastructure.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
	private final OrderRepository orderRepository;

	public Order createOrder(OrderCreateParam orderCreateParam) {

		Order order = Order.builder()
			.name(orderCreateParam.getName())
			.quantity(orderCreateParam.getQuantity())
			.build();
		Order savedOrder = orderRepository.save(order);

		//여기에 rabbitmq로 메세지 발송해야한다
		return savedOrder;
	}
}

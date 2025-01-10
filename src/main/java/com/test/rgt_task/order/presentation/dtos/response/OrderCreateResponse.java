package com.test.rgt_task.order.presentation.dtos.response;

import com.test.rgt_task.order.domain.Order;

import lombok.Getter;

@Getter
public class OrderCreateResponse {
	private Long id;
	public static OrderCreateResponse from(Order order) {
		OrderCreateResponse response = new OrderCreateResponse();
		response.id = order.getId();

		return response;
	}
}




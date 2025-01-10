package com.test.rgt_task.order.application.dtos;

import com.test.rgt_task.order.presentation.dtos.request.OrderCreateRequest;

import lombok.Getter;

@Getter
public class OrderCreateParam {

	private String food;
	private int quantity;


	public static OrderCreateParam from(OrderCreateRequest dto) {
		OrderCreateParam orderCreateParam = new OrderCreateParam();

		orderCreateParam.food = dto.food();
		orderCreateParam.quantity = dto.quantity();
		return orderCreateParam;

	}
}







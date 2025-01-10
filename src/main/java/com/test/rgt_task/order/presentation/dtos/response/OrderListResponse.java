package com.test.rgt_task.order.presentation.dtos.response;

import java.util.List;

import com.test.rgt_task.order.domain.Order;

import lombok.Getter;

@Getter
public class OrderListResponse {
	private List<Order> orderList;

	public static OrderListResponse from(List<Order> orderList){
		OrderListResponse response = new OrderListResponse();
		response.orderList = orderList;
		return response;
	}
}




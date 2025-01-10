package com.test.rgt_task.order.domain;

import com.test.rgt_task.order.enums.OrderStatus;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Order {
	private Long id;
	private String food;
	private String status;
	private int quantity;

	@Builder
	public Order(String food, String status, int quantity) {
		this.food = food;
		this.status = status;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Order{food='" + food + "', quantity=" + quantity + "}";
	}
}
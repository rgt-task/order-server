package com.test.rgt_task.order.domain;

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
	private String name;
	private String status;
	private int quantity;

	@Builder
	public Order(String name, String status, int quantity) {
		this.name = name;
		this.status = status;
		this.quantity = quantity;
	}
}
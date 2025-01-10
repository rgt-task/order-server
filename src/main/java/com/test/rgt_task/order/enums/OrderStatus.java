package com.test.rgt_task.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {
	WAITING("접수됨"),
	PROCESSING("처리중"),
	FINISHED("처리완료");

	private final String description;
}



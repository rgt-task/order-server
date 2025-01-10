package com.test.rgt_task.order.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.rgt_task.common.dto.ApiResponse;
import com.test.rgt_task.order.application.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
	private final OrderService orderService;

	@GetMapping
	public ApiResponse<?> healthCheck(){
		return ApiResponse.of("healthCheck!!");
	}

}

package com.test.rgt_task.order.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.rgt_task.common.dto.ApiResponse;
import com.test.rgt_task.order.application.OrderService;
import com.test.rgt_task.order.application.dtos.OrderCreateParam;
import com.test.rgt_task.order.domain.Order;
import com.test.rgt_task.order.presentation.dtos.request.OrderCreateRequest;
import com.test.rgt_task.order.presentation.dtos.response.OrderCreateResponse;

import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
	private final OrderService orderService;

	@GetMapping
	public ApiResponse<?> healthCheck() {
		return ApiResponse.of("healthCheck!!");
	}

	@PostMapping
	public ApiResponse<?> OrderCreate(@Valid @RequestBody OrderCreateRequest orderCreateDTO) {

		OrderCreateParam orderCreateParam = OrderCreateParam.from(orderCreateDTO);
		Order createdOrder = orderService.createOrder(orderCreateParam);
		OrderCreateResponse orderCreateResponse = OrderCreateResponse.from(createdOrder);

		//가야할 정보 order number,200 code
		return ApiResponse.of(orderCreateResponse);
	}

}

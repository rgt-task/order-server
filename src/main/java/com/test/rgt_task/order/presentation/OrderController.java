package com.test.rgt_task.order.presentation;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.rgt_task.common.dto.ApiResponse;
import com.test.rgt_task.order.application.OrderService;
import com.test.rgt_task.order.application.dtos.OrderCreateParam;
import com.test.rgt_task.order.domain.Order;
import com.test.rgt_task.order.presentation.dtos.request.OrderCreateRequest;
import com.test.rgt_task.order.presentation.dtos.response.OrderCreateResponse;
import com.test.rgt_task.order.presentation.dtos.response.OrderListResponse;

import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
	private final OrderService orderService;

	@GetMapping
	public ApiResponse<?> orderList() {
		List<Order> orderList = orderService.findAll();
		OrderListResponse orderListResponse = OrderListResponse.from(orderList);

		return ApiResponse.of(orderListResponse);
	}


	@PostMapping
	public ApiResponse<?> createOrder(@Valid @RequestBody OrderCreateRequest orderCreateDTO) {

		OrderCreateParam orderCreateParam = OrderCreateParam.from(orderCreateDTO);
		Order createdOrder = orderService.createOrder(orderCreateParam);
		OrderCreateResponse orderCreateResponse = OrderCreateResponse.from(createdOrder);

		//주문 성공시 생성되는 order id를 return
		return ApiResponse.of(orderCreateResponse);
	}

	@PutMapping
	public ApiResponse<?> putOrder() {
		return ApiResponse.of("healthCheck!!");
	}

}

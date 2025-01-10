package com.test.rgt_task.order.infrastructure;

import java.util.List;

import com.test.rgt_task.order.domain.Order;

public interface OrderRepository {
	Order save(Order order);
	List<Order> findAll();
	Order update(String status);
	Order delete(Long id);
}

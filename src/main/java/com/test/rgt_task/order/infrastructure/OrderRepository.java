package com.test.rgt_task.order.infrastructure;

import com.test.rgt_task.order.domain.Order;

public interface OrderRepository {
	Order save(Order order);
	Order update(String status);
	Order delete(Long id);
}

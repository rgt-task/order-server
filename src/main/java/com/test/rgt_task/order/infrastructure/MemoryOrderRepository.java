package com.test.rgt_task.order.infrastructure;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.test.rgt_task.order.domain.Order;

@Repository
public class MemoryOrderRepository implements OrderRepository {
	private static Map<Long, Order> store = new HashMap<>();
	private static long sequence = 0L;

	@Override
	public Order save(Order order) {
		order.setId(++sequence);
		store.put(order.getId(), order);
		return order;
	}

	@Override
	public Order update(String status) {
		return null;
	}

	@Override
	public Order delete(Long id) {
		return null;
	}
}

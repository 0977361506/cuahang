package com.estore.services;

import java.util.List;
import java.util.Optional;

import com.estore.models.Order;
import com.estore.models.OrderDetail;


public interface OrderService {
	void deleteAll();

	void deleteAll(List<Order> entities);

	void delete(Order entity);

	void deleteById(Integer id);

	long count();

	List<Order> findAllById(List<Integer> ids);

	List<Order> findAll();

	boolean existsById(Integer id);

	Optional<Order> findById(Integer id);

	List<Order> saveAll(List<Order> entities);

	Order save(Order entity);

	void save(Order order, List<OrderDetail> list);
}

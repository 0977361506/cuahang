package com.estore.services;

import java.util.List;
import java.util.Optional;

import com.estore.models.Customer;
import com.estore.models.OrderDetail;
import com.estore.models.Product;



public interface OrderDetailService {
	void deleteAll();

	void deleteAll(List<OrderDetail> entities);

	void delete(OrderDetail entity);

	void deleteById(Integer id);

	long count();

	List<OrderDetail> findAllById(List<Integer> ids);

	List<OrderDetail> findAll();

	boolean existsById(Integer id);

	Optional<OrderDetail> findById(Integer id);

	List<OrderDetail> saveAll(List<OrderDetail> entities);

	OrderDetail save(OrderDetail entity);

	List<Product> findsp(Customer customer);
}

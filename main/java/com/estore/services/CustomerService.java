package com.estore.services;

import java.util.List;
import java.util.Optional;

import com.estore.models.Customer;



public interface CustomerService {
	void deleteAll();

	void deleteAll(List<Customer> entities);

	void delete(Customer entity);

	void deleteById(String id);

	long count();

	List<Customer> findAllById(List<String> ids);

	List<Customer> findAll();

	boolean existsById(String id);

	Customer findById(String id);

	List<Customer> saveAll(List<Customer> entities);

	Customer save(Customer entity);

	void update(Customer customer);
}

package com.estore.services;

import java.util.List;
import java.util.Optional;

import com.estore.models.Product;



public interface ProductService {
	void deleteAll();

	void deleteAll(List<Product> entities);

	void delete(Product entity);

	void deleteById(Integer id);

	long count();

	List<Product> findAllById(List<Integer> ids);

	List<Product> findAll();

	boolean existsById(Integer id);

	Product findById(Integer id);

	List<Product> saveAll(List<Product> entities);

	Product save(Product entity);

	List<Product> findByCategory(Integer vip);

	List<Product> findByFavo(String idString);

	List<Product> findBydb(Integer vip);

	void update(Product product);

	List<Product> findByCategorySpecial();
}

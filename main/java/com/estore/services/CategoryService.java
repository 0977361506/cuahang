package com.estore.services;

import java.util.List;
import java.util.Optional;

import com.estore.models.Category;


public interface CategoryService {
	void deleteAll();

	void deleteAll(List<Category> entities);

//	Category delete(Integer id);
	void update(Category category);

	void deleteById(Integer id);

	long count();

	List<Category> findAllById(List<Integer> ids);

	List<Category> findAll();

	boolean existsById(Integer id);

	

	List<Category> saveAll(List<Category> entities);

	Category save(Category entity);
	Category findById(Integer id);

}

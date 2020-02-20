package com.estore.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estore.models.Category;
import com.estore.responsitory.CategoryRepository;


@Service
@Transactional
public class CategoryServiceimpl implements CategoryService {
	@Autowired
	private CategoryRepository cate;
	@Autowired
	EntityManagerFactory entityManagerFactory ;

	@Override
	public Category save(Category entity) {
		return cate.save(entity);
	}

	@Override
	public List<Category> saveAll(List<Category> entities) {
		return (List<Category>) cate.saveAll(entities);
	}



	@Override
	public boolean existsById(Integer id) {
		return cate.existsById(id);
	}

	@Override
	public List<Category> findAll() {
		return (List<Category>) cate.findAll();
	}

	@Override
	public List<Category> findAllById(List<Integer> ids) {
		return (List<Category>)cate.findAllById(ids);
	}

	@Override
	public long count() {
		return cate.count();
	}

	@Override
	public void deleteById(Integer id) {
		cate.deleteById(id);
	}



	@Override
	public void deleteAll(List<Category> entities) {
		cate.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		cate.deleteAll();
	}

	@Override
	public Category findById(Integer id) {
		Session session  = entityManagerFactory.createEntityManager().unwrap(Session.class);
		Category category = session.find(Category.class, id);
		return category;
	}

	//@Override
	//public Category delete(Integer id) {
	//	Session session  = entityManagerFactory.createEntityManager().unwrap(Session.class);
		//Category category = session.find(Category.class, id);
		//session.delete(category);
		//return category;
//	}

	@Override
	public void update(Category category) {
		Session session  = entityManagerFactory.createEntityManager().unwrap(Session.class);
		session.update(category);
	}
	
}

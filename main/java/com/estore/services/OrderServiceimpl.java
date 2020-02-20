package com.estore.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estore.models.Order;
import com.estore.models.OrderDetail;
import com.estore.responsitory.Orderreponsitory;


@Service
public class OrderServiceimpl implements OrderService{
	@Autowired
	private Orderreponsitory OrderRepository;
	@Autowired
	EntityManagerFactory entityManagerFactory ;
	@Override
	public Order save(Order entity) {
		return OrderRepository.save(entity);
	}

	@Override
	public List<Order> saveAll(List<Order> entities) {
		return (List<Order>) OrderRepository.saveAll(entities);
	}

	@Override
	public Optional<Order> findById(Integer id) {
		return OrderRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return OrderRepository.existsById(id);
	}

	@Override
	public List<Order> findAll() {
		return (List<Order>) OrderRepository.findAll();
	}

	@Override
	public List<Order> findAllById(List<Integer> ids) {
		return (List<Order>)OrderRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return OrderRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		OrderRepository.deleteById(id);
	}

	@Override
	public void delete(Order entity) {
		OrderRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<Order> entities) {
		OrderRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		OrderRepository.deleteAll();
	}

	@Override
	public void save(Order order, List<OrderDetail> list) {
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		session.save(order);
		for(OrderDetail m : list) {
			session.save(m);
		}
	
	}
	
}

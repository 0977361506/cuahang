package com.estore.services;

import java.util.List;
import java.util.Optional;


import javax.persistence.EntityManagerFactory;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estore.models.Customer;
import com.estore.models.OrderDetail;
import com.estore.models.Product;
import com.estore.responsitory.OrferDetaireponsitory;




@Service
public class OrderDetailipml implements OrderDetailService{
	@Autowired
	private OrferDetaireponsitory OrderDetailRepository;
	@Autowired
	EntityManagerFactory entityManagerFactory ;
	@Override
	public OrderDetail save(OrderDetail entity) {
		return OrderDetailRepository.save(entity);
	}

	@Override
	public List<OrderDetail> saveAll(List<OrderDetail> entities) {
		return (List<OrderDetail>) OrderDetailRepository.saveAll(entities);
	}

	@Override
	public Optional<OrderDetail> findById(Integer id) {
		return OrderDetailRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return OrderDetailRepository.existsById(id);
	}

	@Override
	public List<OrderDetail> findAll() {
		return (List<OrderDetail>) OrderDetailRepository.findAll();
	}

	@Override
	public List<OrderDetail> findAllById(List<Integer> ids) {
		return (List<OrderDetail>)OrderDetailRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return OrderDetailRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		OrderDetailRepository.deleteById(id);
	}

	@Override
	public void delete(OrderDetail entity) {
		OrderDetailRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<OrderDetail> entities) {
		OrderDetailRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		OrderDetailRepository.deleteAll();
	}

	@Override
	public List<Product> findsp(Customer customer) {
		Session session  = entityManagerFactory.createEntityManager().unwrap(Session.class);
		String hqlString ="select distinct o.product From OrderDetail o where o.order.customer.id=:cid";
		Query query =  session.createQuery(hqlString);
		query.setParameter("cid",customer.getId());
		List<Product> list = query.getResultList();
		return list;
	    
	}
	
}

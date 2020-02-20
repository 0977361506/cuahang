package com.estore.services;


import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estore.models.Customer;
import com.estore.responsitory.Cusummerreponsitory;


@Service
public class CustomerServiceimpl implements CustomerService {
	@Autowired
	private Cusummerreponsitory CustomerRepository;
	@Autowired
	EntityManagerFactory entityManagerFactory ;
	@Override
	public Customer save(Customer entity) {
		return CustomerRepository.save(entity);
	}

	@Override
	public List<Customer> saveAll(List<Customer> entities) {
		return (List<Customer>) CustomerRepository.saveAll(entities);
	}

	@Override
	public Customer findById(String id) {
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		Customer vCustomer = session.find(Customer.class, id);
		return vCustomer;
	}

	@Override
	public boolean existsById(String id) {
		return CustomerRepository.existsById(id);
	}

	@Override
	public List<Customer> findAll() {
		return (List<Customer>) CustomerRepository.findAll();
	}

	@Override
	public List<Customer> findAllById(List<String> ids) {
		return (List<Customer>)CustomerRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return CustomerRepository.count();
	}


	@Override
	public void delete(Customer entity) {
		CustomerRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<Customer> entities) {
		CustomerRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		CustomerRepository.deleteAll();
	}

	@Override
	public void deleteById(String id) {
		CustomerRepository.deleteById(id);
		
	}

	@Override
	public void update(Customer customer) {
		Session session  = entityManagerFactory.createEntityManager().unwrap(Session.class);
		session.update(customer);
	}
}

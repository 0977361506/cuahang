package com.estore.services;

import java.util.List;


import javax.persistence.Query;
import javax.persistence.EntityManagerFactory;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estore.models.Product;
import com.estore.responsitory.ProductReponsitory;


@Service
@Transactional
public class ProductSeviceimpl implements ProductService{
	@Autowired
	private ProductReponsitory ProductRepository;
	@Autowired
	EntityManagerFactory entityManagerFactory ;

	@Override
	public Product save(Product entity) {
		return ProductRepository.save(entity);
	}

	@Override
	public List<Product> saveAll(List<Product> entities) {
		return (List<Product>) ProductRepository.saveAll(entities);
	}

	@Override
	public Product findById(Integer id) {
		Session session  = entityManagerFactory.createEntityManager().unwrap(Session.class);
		Product product = session.find(Product.class, id);
		return product;
	}

	@Override
	public boolean existsById(Integer id) {
		return ProductRepository.existsById(id);
	}

	@Override
	public List<Product> findAll() {
		return (List<Product>) ProductRepository.findAll();
	}

	@Override
	public List<Product> findAllById(List<Integer> ids) {
		return (List<Product>)ProductRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return ProductRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		ProductRepository.deleteById(id);
	}

	@Override
	public void delete(Product entity) {
		ProductRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<Product> entities) {
		ProductRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		ProductRepository.deleteAll();
	}

	@Override
	public List<Product> findByCategory(Integer vip) {
		Session session  = entityManagerFactory.createEntityManager().unwrap(Session.class);
		String hqlString ="From Product p where p.category.id=:cid";
		Query query =  session.createQuery(hqlString);
		query.setMaxResults(9);
		query.setParameter("cid",vip);
		List<Product> list = query.getResultList();
		return list;
	}

	@Override
	public List<Product> findByFavo(String idString) {
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		String hql = "from Product p  where p.id IN ("+idString+")";
		Query query = session.createQuery(hql);
		query.setMaxResults(9);
		List<Product> list = query.getResultList();
		return list;
		
			}

	@Override
	public List<Product> findBydb(Integer vip) {
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		String hql = "";

		
		if(vip==0) {
			//mới
			 hql = "from Product p ORDER BY p.productDate DESC";
		
		}
		else if(vip==1) {
			//ban chay
			 hql = "from Product p ORDER BY size(p.orderDetails) DESC";
		}
		else if(vip==2) {
			//xem nhieu
			 hql = "from Product p ORDER BY p.viewcount DESC";
			
		}
		else if(vip== 3) {
			//giam gia discount
			 hql = "from Product p ORDER BY p.discount DESC";
			
		}
		Query query = session.createQuery(hql);
		query.setMaxResults(9);
		List<Product> list = query.getResultList();
		return list;
		
		
	}

	@Override
	public void update(Product product) {
		Session session  = entityManagerFactory.createEntityManager().unwrap(Session.class);
		session.update(product);
	}
	@Override
	public List<Product> findByCategorySpecial() {
		Session session  = entityManagerFactory.createEntityManager().unwrap(Session.class);
		String hqlString ="From Product p where p.special=true";
		Query query =  session.createQuery(hqlString);
		query.setMaxResults(12);
		List<Product> list = query.getResultList();
		return list;
	}
	
}

package com.estore.services;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import javax.transaction.Transactional;


import org.hibernate.Session;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class reportDAOipml implements reportDAO {
	@Autowired
	EntityManagerFactory entityManagerFactory ;
	@Override
	public List<Object[]> inventory() {
	String hqlString= "select p.category.nameVN,"
			+ "SUM(p.quantity),"
			+ "SUM(p.unitPrice*p.quantity),"
		    + "MIN(p.unitPrice),"
			+ "MAX(p.unitPrice),"
			+ "AVG(p.unitPrice)"
			+ "FROM Product p"
			+ " GROUP BY p.category.nameVN";
	Session session  = entityManagerFactory.createEntityManager().unwrap(Session.class);
	Query query =  session.createQuery(hqlString);
	List<Object[]> list = query.getResultList();
		return list;
	}

	@Override
	public List<Object[]> thongketheoloaimh() {
		String hqlString= "select p.product.category.nameVN,"
				+ "SUM(p.quantity),"
				+ "SUM(p.unitPrice*p.quantity),"
			    + "MIN(p.unitPrice),"
				+ "MAX(p.unitPrice),"
				+ "AVG(p.unitPrice)"
				+ "FROM OrderDetail p"
				+ " GROUP BY p.product.category.nameVN";
		Session session  = entityManagerFactory.createEntityManager().unwrap(Session.class);
		Query query =  session.createQuery(hqlString);
		List<Object[]> list = query.getResultList();
			return list;
	}

	@Override
	public List<Object[]> thongketheokh() {
		String hqlString= "select p.order.id,"
				+ "SUM(p.quantity),"
				+ "SUM(p.unitPrice*p.quantity),"
			    + "MIN(p.unitPrice),"
				+ "MAX(p.unitPrice),"
				+ "AVG(p.unitPrice)"
				+ "FROM OrderDetail p"
				+ " GROUP BY p.order.id";
		Session session  = entityManagerFactory.createEntityManager().unwrap(Session.class);
		Query query =  session.createQuery(hqlString);
		List<Object[]> list = query.getResultList();
			return list;
	}

	@Override
	public List<Object[]> theonam() {
		String hqlString= "select YEAR(p.order.orderDate),"
				+ "SUM(p.quantity),"
				+ "SUM(p.unitPrice*p.quantity),"
			    + "MIN(p.unitPrice),"
				+ "MAX(p.unitPrice),"
				+ "AVG(p.unitPrice)"
				+ "FROM OrderDetail p"
				+ " GROUP BY YEAR(p.order.orderDate)"
				+ " ORDER BY YEAR(p.order.orderDate) DESC";
		Session session  = entityManagerFactory.createEntityManager().unwrap(Session.class);
		Query query =  session.createQuery(hqlString);
		List<Object[]> list = query.getResultList();
			return list;
	}

	@Override
	public List<Object[]> theoquy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> theothang() {
		String hqlString= "select MONTH(p.order.orderDate),"
				+ "SUM(p.quantity),"
				+ "SUM(p.unitPrice*p.quantity),"
			    + "MIN(p.unitPrice),"
				+ "MAX(p.unitPrice),"
				+ "AVG(p.unitPrice)"
				+ "FROM OrderDetail p"
				+ " GROUP BY MONTH(p.order.orderDate)"
				+ " ORDER BY MONTH(p.order.orderDate) DESC";
		Session session  = entityManagerFactory.createEntityManager().unwrap(Session.class);
		Query query =  session.createQuery(hqlString);
		List<Object[]> list = query.getResultList();
			return list;
	}

}

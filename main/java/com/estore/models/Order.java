package com.estore.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Orderss")
public class Order {
 @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
 Integer  id;
 @Temporal(TemporalType.DATE)
 @DateTimeFormat(pattern = "MM/dd/yyyy")
 Date  orderDate;
 String address ;
 Double omount ;

 String description ;
//String  customerId ;
 @ManyToOne
 @JoinColumn(name = "CustomerId")
 Customer customer ;
 @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)	
 List<OrderDetail> orderDetails ;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Date getOrderDate() {
	return orderDate;
}
public void setOrderDate(Date orderDate) {
	this.orderDate = orderDate;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Double getOmount() {
	return omount;
}
public void setOmount(Double omount) {
	this.omount = omount;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
public List<OrderDetail> getOrderDetails() {
	return orderDetails;
}
public void setOrderDetails(List<OrderDetail> orderDetails) {
	this.orderDetails = orderDetails;
}
 
}

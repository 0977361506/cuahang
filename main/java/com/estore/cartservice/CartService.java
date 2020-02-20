package com.estore.cartservice;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.estore.models.Product;
import com.estore.services.ProductService;

@SessionScope //scopedTarget.cartService
@Service
public class CartService {
	@Autowired
	ProductService productService;
  public Map<Integer,Product> lisMap = new HashMap<>();
  public void add(Integer id) {
	Product product = lisMap.get(id);
	if(product == null) {
		product = productService.findById(id);
		product.setQuantity(1);
		lisMap.put(id, product);
		}
	else {
		product.setQuantity(product.getQuantity()+1);
	}
  }
  public void remove(Integer id) {
	  lisMap.remove(id);
  }
 public void clear() {
	 lisMap.clear();
 }
 public void update(Integer id ,int sl ) {
	 Product product = lisMap.get(id);
	 product.setQuantity(sl);
	 
 }
 public int getCount() {
	 Collection<Product> list =  this.getItems();
	int count =0;
	for(Product product : list) {
	count += product.getQuantity();
	}
	return count ;
 }
 public double getAmount() {
	 Collection<Product> list =  this.getItems();
		double amount =0;
		for(Product product : list) {
			amount+= (product.getQuantity()*product.getUnitPrice());
		}
		return amount ;
 }
 public  Collection<Product> getItems(){
	return  lisMap.values();
	
 }
}

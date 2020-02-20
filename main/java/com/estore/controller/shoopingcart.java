package com.estore.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.estore.cartservice.CartService;
import com.estore.models.Customer;
import com.estore.models.Product;




@Controller
public class shoopingcart {
	@Autowired
	CartService  cart ;
	  @Autowired 
	  HttpSession session;
	
	@ResponseBody
   @RequestMapping("/cart/add/{id}")
 //url:"/product/addtoFavo/"+id,
	//url:"/cart/add/"+id
   public Object[] cartadd (@PathVariable("id") Integer id) {
	    cart.add(id);
	    Object[] ds = {cart.getCount(),cart.getAmount()};
	    return ds ;
   }

	
	@RequestMapping("/cart/view")
	  private String about(Model model) {
		return "cart/view";
	}
	@RequestMapping("/cart/clear")
	  private String clear(Model model) {
		cart.clear();
		//Collection<Product>products = cart.getItems();
		//model.addAllAttributes(products);
		return "cart/view";
	}
	// clear
	@ResponseBody
	@RequestMapping("/cart/remove/{id}")
	  public Object[]  clear(@PathVariable("id") Integer id) {
		cart.remove(id);
		 Object[] ds = {cart.getCount(),cart.getAmount()};
	    return ds;
	    
	}
	
	@ResponseBody
	@RequestMapping("/cart/update/{id}/{qty}")
	  public Object[]  update(@PathVariable("id") Integer id,@PathVariable("qty") Integer qty) {
		cart.update(id, qty);;
		 Object[] ds = {cart.getCount(),cart.getAmount()};
	    return ds;
	    
	}
	
}

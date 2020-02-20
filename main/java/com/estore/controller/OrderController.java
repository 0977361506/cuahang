      package com.estore.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.estore.cartservice.CartService;
import com.estore.models.Customer;
import com.estore.models.Order;
import com.estore.models.OrderDetail;
import com.estore.models.Product;
import com.estore.services.OrderDetailService;
import com.estore.services.OrderService;

@Controller
public class OrderController {
	@Autowired
	HttpSession session;
	@Autowired
	CartService cart;
	@Autowired
	OrderService vip;
	@Autowired
	OrderDetailService vip1;
	
	@GetMapping("/thanhtoan/order")
	  public String checkout(@ModelAttribute("order") Order order) {
	Customer customer =(Customer) session.getAttribute("user");
		order.setOrderDate(new Date());
		order.setCustomer(customer);
		order.setOmount(cart.getAmount());
		return "cart/thanhtoan";
}
	
	@PostMapping("/thanhtoan/order")
	public String thanhtoan(Model model,@ModelAttribute("order") Order order) {
		Collection<Product> lisCollection= cart.getItems();
		List<OrderDetail> list = new ArrayList<OrderDetail>();
		for(Product product :lisCollection) {
			OrderDetail m = new OrderDetail();
			m.setOrder(order);
			m.setProduct(product);
			m.setDiscount(product.getDiscount());
			m.setUnitPrice(product.getUnitPrice());
			m.setQuantity(product.getQuantity());
			list.add(m);
		}
		vip.save(order,list);
		cart.clear();
		model.addAttribute("thanhtoan","thanh toan thanh cong");
		return "cart/thanhtoan";
	}
	@RequestMapping("/cart/viewd")
	public String damua(Model model) {
		Customer customer = (Customer) session.getAttribute("user");
		List<Product> products = vip1.findsp(customer);
		model.addAttribute("danhsach",products);
		return "product/danhsach";
		
	}
}

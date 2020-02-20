package com.estore.admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.estore.models.Customer;
import com.estore.services.CustomerService;

@Controller
public class CustomerManager {
  @Autowired
  CustomerService dao;
  @Autowired
  ServletContext text;
  @RequestMapping("/admin/customer/index")
  public String index(Model model) {
	  Customer entity = new Customer();
	List<Customer>  list = dao.findAll();
	  model.addAttribute("entity", entity);
	  model.addAttribute("list", list);

  return "admin/customer/index";
}
  @RequestMapping("/admin/customer/edit/{id}")
  public String edit(Model model,@PathVariable("id") String id) {
	  Customer entity = dao.findById(id);
	  List<Customer>  list = dao.findAll();
	  model.addAttribute("entity", entity);
	  model.addAttribute("list", list);

  return "admin/customer/index";
}
  @RequestMapping("/admin/customer/create")
  public String create(RedirectAttributes model,@ModelAttribute("entity") Customer customer,
		  
		@RequestParam("photo_file") MultipartFile file) throws IllegalStateException, IOException {
	  if(file.isEmpty()) {
		  customer.setPhoto("vip112.jpg");
	  }else {
		  customer.setPhoto(file.getOriginalFilename());
		  String pathString = text.getRealPath("/static/ảnh mạng/"+customer.getPhoto());
		  file.transferTo(new File(pathString));
	  }
	 dao.save(customer);
	 model.addAttribute("message", "Giao dich thanh coong");
  return "redirect:/admin/customer/index";
}
  @RequestMapping("/admin/customer/update")
  public String update(RedirectAttributes model,@ModelAttribute("entity") Customer customer) {
	 dao.update(customer);
	 model.addAttribute("message", "cap nhat thanh coong");
  return "redirect:/admin/customer/edit/"+customer.getId();
}
  @RequestMapping(value = { "/admin/customer/delete","/admin/customer/delete/{id}"})
  public String deString(RedirectAttributes model,@RequestParam(value = "id",required = false) String id1 , @PathVariable(value = "id", required = false) String id2) {

	 if(id1!= null) {
	
		 dao.deleteById(id1);
	 }
	 else {
		
		
		 dao.deleteById(id2);
	 }
	 model.addAttribute("message", "Xoa  thanh coong");
  return "redirect:/admin/customer/index";
}
}
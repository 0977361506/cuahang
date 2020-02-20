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

import com.estore.models.Product;
import com.estore.services.ProductService;

@Controller
public class productmanager {
  @Autowired
  ProductService dao;
  @Autowired
  ServletContext text;
  @RequestMapping("/admin/product/index")
  public String index(Model model) {
	  Product entity = new Product();
	List<Product>  list = dao.findAll();
	  model.addAttribute("entity", entity);
	  model.addAttribute("list", list);

  return "admin/product/index";
}
  @RequestMapping("/admin/product/edit/{id}")
  public String edit(Model model,@PathVariable("id") Integer id) {
	  Product entity = dao.findById(id);
	  List<Product>  list = dao.findAll();
	  model.addAttribute("entity", entity);
	  model.addAttribute("list", list);

  return "admin/product/index";
}
  @RequestMapping("/admin/product/create")
  public String create(RedirectAttributes model,@ModelAttribute("entity") Product product,
		  
		@RequestParam("photo_file") MultipartFile file) throws IllegalStateException, IOException {
	  if(file.isEmpty()) {
		  product.setImage("vip112.jpg");
	  }else {
		  product.setImage(file.getOriginalFilename());
		  String pathString = text.getRealPath("/static/ảnh mạng/"+product.getImage());
		  file.transferTo(new File(pathString));
	  }
	 dao.save(product);
	 model.addAttribute("message", "Giao dich thanh coong");
  return "redirect:/admin/product/index";
}
  @RequestMapping("/admin/product/update")
  public String update(RedirectAttributes model,@ModelAttribute("entity") Product product) {
	 dao.update(product);;
	 model.addAttribute("message", "cap nhat thanh coong");
  return "redirect:/admin/product/edit/"+product.getId();
}
  @RequestMapping(value = { "/admin/product/delete","/admin/product/delete/{id}"})
  public String deString(RedirectAttributes model,@RequestParam(value = "id",required = false)Integer id1 , @PathVariable(value = "id", required = false) Integer id2) {

	 if(id1!= null) {
	
		 dao.deleteById(id1);
	 }
	 else {
		
		
		 dao.deleteById(id2);
	 }
	 model.addAttribute("message", "Xoa  thanh coong");
  return "redirect:/admin/product/index";
}
}
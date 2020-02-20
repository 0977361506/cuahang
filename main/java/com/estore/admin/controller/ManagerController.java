package com.estore.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.estore.models.Category;
import com.estore.services.CategoryService;

@Controller
public class ManagerController {
  @Autowired
  CategoryService dao;
  @RequestMapping("/admin/category/index")
  public String index(Model model) {
	  Category entity = new Category();
	List<Category>  list = dao.findAll();
	  model.addAttribute("entity", entity);
	  model.addAttribute("list", list);

  return "admin/category/index";
}
  @RequestMapping("/admin/category/edit/{id}")
  public String edit(Model model,@PathVariable("id") Integer id) {
	  Category entity = dao.findById(id);
	  List<Category>  list = dao.findAll();
	  model.addAttribute("entity", entity);
	  model.addAttribute("list", list);

  return "admin/category/index";
}
  @RequestMapping("/admin/category/create")
  public String create(RedirectAttributes model,@ModelAttribute("entity") Category category) {
	 dao.save(category);
	 model.addAttribute("message", "Giao dich thanh coong");
  return "redirect:/admin/category/index";
}
  @RequestMapping("/admin/category/update")
  public String update(RedirectAttributes model,@ModelAttribute("entity") Category category) {
	 dao.update(category);
	 model.addAttribute("message", "cap nhat thanh coong");
  return "redirect:/admin/category/edit/"+category.getId();
}
  @RequestMapping(value = { "/admin/category/delete","/admin/category/delete/{id}"})
  public String deString(RedirectAttributes model,@RequestParam(value = "id",required = false) Integer id1 , @PathVariable(value = "id", required = false) Integer id2) {

	 if(id1!= null) {
	
		 dao.deleteById(id1);
	 }
	 else {
		
		
		 dao.deleteById(id2);
	 }
	 model.addAttribute("message", "Xoa  thanh coong");
  return "redirect:/admin/category/index";
}
}
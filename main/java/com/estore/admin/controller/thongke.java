package com.estore.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.estore.services.reportDAO;

@Controller
public class thongke {
	@Autowired
	reportDAO dao;
  @RequestMapping("/admin/inventory/index")
  public String index(Model model) {
	     model.addAttribute("data",dao.inventory());
	  return "admin/inventory/index";
  }
  @RequestMapping("/admin/inventory/category")
  public String tkmh(Model model) {
	     model.addAttribute("data",dao.thongketheokh());
	  return "admin/inventory/tktheomh";
  }
  @RequestMapping("/admin/inventory/customer")
  public String tkkh(Model model) {
	     model.addAttribute("data",dao.thongketheoloaimh());
	  return "admin/inventory/tktheokh";
  }
  @RequestMapping("/admin/inventory/year")
  public String tktheonam(Model model) {
	     model.addAttribute("data",dao.theonam());
	  return "admin/inventory/tktheonam";
  }
  @RequestMapping("/admin/inventory/month")
  public String tktheothang(Model model) {
	     model.addAttribute("data",dao.theothang());
	  return "admin/inventory/tktheothang";
  }
}

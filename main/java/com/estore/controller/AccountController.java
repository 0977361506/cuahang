package com.estore.controller;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.jboss.jandex.TypeTarget.Usage;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.estore.bean.MailInfo;
import com.estore.models.Customer;
import com.estore.services.CookkieService;
import com.estore.services.CustomerService;
import com.estore.services.MailService;


@Controller

public class AccountController {
  @Autowired
  CustomerService cus;
  @Autowired 
  HttpSession session;
  @Autowired
  CookkieService cooki;
  @Autowired
  ServletContext app;
  @Autowired
  MailService mail;
  
  
  @GetMapping("/account/login")
	public String login(Model model) {
	  Cookie cookie = cooki.read("id1");
	  Cookie cookie2 = cooki.read("pw1");
	  if(cookie!=null) {
		 String idString = cookie.getValue();
		  String pwString = cookie2.getValue();
		 model.addAttribute("idd", idString);
		 model.addAttribute("pww", pwString);
	  }
		 return "account/login";
	}
	@PostMapping("/account/login")
	public String login(Model model,@RequestParam("id") String id,
			@RequestParam("pw") String pw, @RequestParam(value = "rm" ,defaultValue="false") boolean rm) {
		Customer customer = cus.findById(id);
		if(customer==null) {
			model.addAttribute("error", "tai khoan khong ton taij xin vui long kiem tra lai");
			
		}
		else if(!customer.getPassword() .equals(pw)) {
			model.addAttribute("error", "vui long kiem tra  laij password");
			
		}
		else if(customer.getActivated()==false) {
			model.addAttribute("error", "vui long kich hoat tai khoan");
			
		}
		else {
			model.addAttribute("error", "dagn nhap thanh cong");
			session.setAttribute("user", customer);
			if(rm==true) {
				cooki.creat("id1", customer.getId(), 20);
				cooki.creat("pw1", customer.getPassword(), 20);
			}else {
				cooki.delete("id");
				cooki.delete("pw");
			}
			String urlString = (String) session.getAttribute("url");
			return "redirect:"+urlString;
			
			
		}
		 return "account/login";
	}
	@RequestMapping("/account/logoff")
	public String logoff() {

		session.removeAttribute("user");
		return "redirect:/home/index";
	}
    // dang ki
	
	@GetMapping("/account/register")
	public String register1(Model model) {
	  Customer customer= new Customer();
	  model.addAttribute("form" ,customer);
		 return "account/register";
	
	}
	@PostMapping("/account/register")
	public String register(Model model, @Validated @ModelAttribute("form") Customer customer,BindingResult errors,
			@RequestParam("photo_file") MultipartFile file) throws IllegalStateException, IOException, MessagingException {
	 if(errors.hasErrors()) {
		 model.addAttribute("message", "vui long sua cac loi");
		 return "account/register";
	 }else {
		 Customer customer2 = cus.findById(customer.getId());
		 if(customer2!=null) {
			 model.addAttribute("message","tai khoan da ton tai");
		 }
	 }
		
		if(file.isEmpty()) {
		 customer.setPhoto("User.png");
	 }
	 else {
		 String dir=  app.getRealPath("/static/ảnh mạng");
		   File f  = new File(dir,file.getOriginalFilename());
		   file.transferTo(f);
			customer.setPhoto(f.getName());
			System.out.println("ten duogn dan"+dir);
			System.out.println("ten file goc"+ file.getOriginalFilename());
			System.out.println("ten file moi"+ f.getName());
	 }
	 customer.setActivated(false);
	 customer.setAdmin(false);
	 cus.save(customer);
	 model.addAttribute("error","dang ki thnah cong");
	// String from ="mailamvu5799@gmail.com";
	// String to = customer.getEmail();
	// String subjecString= " wellcome";
	// String bodyString= "hya lma";
	 //MailInfo info = new MailInfo(from, to, subjecString, bodyString);
	 //mail.send(info);
		 return "account/register";
	}
	@ResponseBody
	@RequestMapping("/home/language")
	public void mess() {
		
	}

}



package com.estore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Homecontroller {
	@RequestMapping("/home/about")
	  private String about() {
		return "home/about";
	}
	@RequestMapping("/home/contact")
	  private String contact() {
		return "home/contact";
	}
	@RequestMapping("/home/feedback")
	  private String feedback() {
		return "home/index";
	}
	@RequestMapping("/home/faq")
	  private String faq() {
		return "home/faq";
	}
	
}

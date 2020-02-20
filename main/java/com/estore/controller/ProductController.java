package com.estore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.persistence.Id;
import javax.security.auth.Subject;
import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.ls.LSInput;

import com.estore.bean.MailInfo;
import com.estore.models.Product;
import com.estore.services.CookkieService;
import com.estore.services.MailService;
import com.estore.services.ProductService;


@Controller
public class ProductController {
  @Autowired
ProductService prov ;
  @Autowired
  CookkieService Cookkiess;
  @Autowired
  MailService mail;
	@RequestMapping("/home/index")
	  private String index(Model model) {
		List<Product> products = prov.findByCategorySpecial();
		model.addAttribute("list11", products);
		return "home/index";
	}
	@RequestMapping("/Product/list/{cid}")
	  private String about(Model model,@PathVariable("cid") Integer vip) {
	List<Product> products = prov.findByCategory(vip);
	model.addAttribute("cate", products);
		return "product/list";
	}
	@RequestMapping("/product/detail/{cid}")
	  private String detail(Model model,@PathVariable("cid") Integer vip) {
	Product products = prov.findById(vip);
	List<Product> lists = prov.findByCategory(products.getCategory().getId());
	model.addAttribute("pro", products);
	model.addAttribute("pro1", lists);
	
	Cookie cookie2 = Cookkiess.read("view");
	String vaString = vip.toString();
	if(cookie2!=null) {
		vaString= cookie2.getValue();
		vaString += ","+ String.valueOf(vip);
		
		
	}
	Cookkiess.creat("view", vaString, 20);
	List<Product> listview = prov.findByFavo(vaString);
	model.addAttribute("views", listview);
		return "product/detail";
	}
	
	 @RequestMapping("/product/favo")
	 public String sanphamyeuthich(Model model) {
			Cookie cookie = Cookkiess.read("favo");
			if(cookie!=null) {
			String idString = cookie.getValue();
			List<Product> dsList  = prov.findByFavo(idString);
			model.addAttribute("favo", dsList);
			}
			
			return "product/favo";
	 }
	@ResponseBody
	@RequestMapping("/product/addtoFavo/{cid}")
	  private boolean AddtoFavo(Model model,@PathVariable("cid") Integer vip) {
         Cookie cookie = Cookkiess.read("favo");
         String value = vip.toString();
         if(cookie!=null) {
        	value = cookie.getValue();
        	if(!value.contains(vip.toString())) {
        		value+=","+vip.toString();
        	}
        	else {
        		return false;
        	}
        			
         }
         Cookkiess.creat("favo", value, 30);
		return true;
	}
	@RequestMapping("/product/db/{cid}")
	  private String specail(Model model,@PathVariable("cid") Integer vip) {
	List<Product> products = prov.findBydb(vip);
     
	model.addAttribute("cate", products);
		return "product/list";
	}
	  
	@ResponseBody
	@RequestMapping("/product/send-to-friend")
	  public boolean SendtoFried(Model model, MailInfo info) throws MessagingException{
                       //  @RequestParam("sender") String from,
                        // @RequestParam(value = "email" , required=false) String email,
                        // @RequestParam( value = "comments" , required=false ) String comments) throws MessagingException {
		 info.setSubject("thong tin hsng hoa");

		
		try {
			mail.send(info);
			return true;
	
		} catch (Exception e) {
			return false;
		}
			
		
	}  
	@RequestMapping("/timkiem/sanpham")
	public String timkiemn(Model model, @RequestParam("keyword") String tk) {
		List<Product> products = prov.findAll();
		List<Product> spList = new ArrayList<Product>();
		for(Product product : products) {
			if(product.getName().toUpperCase().contains(tk.toUpperCase())) {
				spList.add(product);
			}
		}
		List<Product> vList = spList;
		model.addAttribute("tkiem",vList);
		return "product/timkiem";
	}
}


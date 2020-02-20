package com.estore.interceptor;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.estore.models.Category;
import com.estore.services.CategoryService;



@Component
public class ShareInterceptor extends HandlerInterceptorAdapter{
 @Autowired
 CategoryService depat;
  @Override
public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
		ModelAndView modelAndView) throws Exception {
	List<Category> list = depat.findAll();
	 request.setAttribute("vip", list);
}
}

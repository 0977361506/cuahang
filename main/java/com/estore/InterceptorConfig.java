package com.estore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.estore.interceptor.Sericury;
import com.estore.interceptor.ShareInterceptor;




@Configuration
public class InterceptorConfig implements  WebMvcConfigurer{
	@Autowired
	ShareInterceptor share ;
	@Autowired
	Sericury sem;
  @Override
public void addInterceptors(InterceptorRegistry registry) {
	registry.addInterceptor(share).addPathPatterns("/**");
	registry.addInterceptor(sem).addPathPatterns("/thanhtoan/order");
}
}

package com.estore.services;

import java.util.Base64;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CookkieService {
 @Autowired
 HttpServletRequest request;
 @Autowired
 HttpServletResponse response;

public Cookie creat(String name ,String value , int day ) {
	String enString = Base64.getEncoder().encodeToString(value.getBytes());
	Cookie cookie = new Cookie(name, enString);
	
	cookie.setMaxAge(day*24*3600);
	cookie.setPath("/");
	response.addCookie(cookie);
	return cookie;
	
}
public Cookie read(String name) {
	Cookie[] cookies = request.getCookies();
	if(cookies!=null) {
		for(Cookie cookie :cookies) {
			if(cookie.getName().equalsIgnoreCase(name)) {
			String valuString =	new String(Base64.getDecoder().decode(cookie.getValue()));
	      cookie.setValue(valuString);
			return cookie;
			}
		}
	}
	return null;
}
public void delete(String nameString ) {
	this.creat(nameString,"",0);
}

 
}

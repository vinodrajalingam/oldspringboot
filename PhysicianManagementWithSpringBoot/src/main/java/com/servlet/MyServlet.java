package com.servlet;

import javax.servlet.annotation.WebServlet;

import org.springframework.web.bind.annotation.RequestMapping;

@WebServlet
public class MyServlet 
{
	@RequestMapping("/")
	public void callServ() {
		
		System.out.println("Inside Servlet");
	}
}

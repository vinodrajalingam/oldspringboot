package com.config;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
public class CustomWebMVC extends WebMvcConfigurerAdapter {
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
		super.addViewControllers(registry);
		registry.addViewController("/")
		.setViewName("forward:/index");

	}

}

package com.springApplication;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com")
@EntityScan("com")
@EnableJpaRepositories("com")
public class SpringBootWebApplication {
	
	private static final Log logger = LogFactory.getLog(SpringBootWebApplication.class);
	
	public static void main(String args[]) {
		
		ApplicationContext cntxt = null;

		try {			
			cntxt = SpringApplication.run(SpringBootWebApplication.class, args);	
			logger.info("Spring Boot Container Started !!");
			
		} catch (Exception e) {
			e.printStackTrace();			
			logger.info("Error in creating Spring Boot Container !!");
		}
		if (cntxt != null) {
			/*String[] beanNames = cntxt.getBeanDefinitionNames();
			for (String beanName : beanNames) {
				logger.info("beanName  " + beanName);
			}*/
		}
	}
}
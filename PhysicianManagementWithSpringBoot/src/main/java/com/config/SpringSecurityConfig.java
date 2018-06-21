package com.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Value("${ldap.urls}")
	private String ldapUrls;
	
	@Value("${ldap.base.dn}")
	private String ldapBaseDn;
	
	@Value("${ldap.username}")
	private String ldapSecurityPrincipal;
	
	@Value("${ldap.password}")
	private String ldapPrincipalPassword;
	
	@Value("${ldap.user.dn.pattern}")
	private String ldapUserDnPattern;
	
	@Value("${ldap.enabled}")
	private String ldapEnabled;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable().authorizeRequests().antMatchers("/").permitAll();

		http.authorizeRequests().antMatchers("/**/delete").fullyAuthenticated()
			   .and().httpBasic()
			    .and().csrf().disable();
		//http
    	//.authorizeRequests()
    		//.antMatchers("/**/delete").fullyAuthenticated()
        	//.antMatchers("/").permitAll();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		if(Boolean.parseBoolean(ldapEnabled)) {
			
			System.out.println("inside if and the password is "+ldapPrincipalPassword+" and user is "+ldapSecurityPrincipal);
			/*auth
				.ldapAuthentication()
				.contextSource()
					.url(ldapUrls + ldapBaseDn)
						.managerDn(ldapSecurityPrincipal)
						.managerPassword(ldapPrincipalPassword)
					.and()
						.userDnPatterns(ldapUserDnPattern);*/
			auth.ldapAuthentication()
	        .userSearchFilter("uid=*")
	        .contextSource()
	        .url(ldapUrls + ldapBaseDn);
			System.out.println("after auth");
		} else {
			System.out.println("inside elae and the password is "+ldapPrincipalPassword+" and user is "+ldapSecurityPrincipal);
	        auth
	        .inMemoryAuthentication()
	            .withUser("user").password("password").roles("USER")
	            .and()
	            .withUser("admin").password("admin").roles("ADMIN")
	            ;
	        
	        System.out.println("after auth");
		}
	}
}
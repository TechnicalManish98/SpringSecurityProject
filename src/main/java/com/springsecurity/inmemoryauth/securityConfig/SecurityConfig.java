package com.springsecurity.inmemoryauth.securityConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		//No entrypted password
		
		auth.inMemoryAuthentication().withUser("manish").password("{noop}manish").authorities("ADMIN");
		auth.inMemoryAuthentication().withUser("abc").password("{noop}abc").authorities("Employee");
		auth.inMemoryAuthentication().withUser("xyz").password("{noop}xyz").authorities("Student");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//URL-AccessType
		
		http.authorizeRequests()
		.antMatchers("/home").permitAll()
		.antMatchers("/welcome").authenticated()
		.antMatchers("/admin").hasAuthority("ADMIN")
		.antMatchers("/emp").hasAuthority("Employee")
		.antMatchers("/student").hasAuthority("Student")
		
		//Login Form details
		
		.and()
		.formLogin()
		.defaultSuccessUrl("/welcome",true)
		
		// Logout details
		
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		
		//Exception details
		
		.and()
		.exceptionHandling()
		.accessDeniedPage("/denied");
		
	}
}

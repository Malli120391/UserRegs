package com.javacodes.springmvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		
		.authorizeRequests()
		.antMatchers("/", "/hone").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.and()
		.logout()
		.permitAll();
		
	}
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("malleswara").password("{noop}malli").roles("USER").and()
            .withUser("admin")
            .password("{noop}admin").credentialsExpired(true)
            .accountExpired(true).accountLocked(true)
            .authorities("WRITE_PRIVILEGES", "READ_PRIVILEGES")
            .roles("ADMIN");
    }

}

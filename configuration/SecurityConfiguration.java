package com.huynguyen.configuration;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;
	
	@Bean
	public AuthenticationSuccessHandler successHandler() {
	    return new MyCustomLoginSuccessHandler("/yourdefaultsuccessurl");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("SELECT username, password, enabled FROM user WHERE username=?")
		.authoritiesByUsernameQuery("SELECT username, role FROM user WHERE username=?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
		.and().authorizeRequests().antMatchers("/user/**").hasRole("USER")
		.anyRequest().permitAll().and().formLogin().loginPage("/log-in").loginProcessingUrl("/login")
		.usernameParameter("username").passwordParameter("password").successHandler(successHandler())
		.failureUrl("/error?error=fail").and().exceptionHandling().accessDeniedPage("/error?error=deny");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/static/**","/files/**");
	}

}

package com.neosoft.springbootsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.neosoft.springbootsecurity.handler.MyAuthenticationFailureHandler;
import com.neosoft.springbootsecurity.handler.MyLogoutSuccessHandler;
import com.neosoft.springbootsecurity.handler.MySimpleUrlAuthenticationHandler;

import org.springframework.security.authentication.AuthenticationProvider;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationProvider authenticationProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

//		http.authorizeRequests().anyRequest()
//				
//			
//		
//		
//				.authenticated()
//				.and()
//				.anonymous().and()
//				.formLogin().loginPage("/login")
//				.loginProcessingUrl("/authenticate")
//				.defaultSuccessUrl("/home", true) // true value default every page redirect false retain previous page 
//				.failureUrl("/fails")
//				.permitAll()
//				.and()
//				.logout()
//				.logoutSuccessUrl("/logout-user") //after logout redirect
//				.deleteCookies("JSESSIONID")
//				.permitAll();

		
		http.authorizeRequests()
			.antMatchers("/anonymous*").anonymous()
			.antMatchers("/login").permitAll()
			.antMatchers("/home").permitAll()
			.antMatchers("/fails").permitAll()
			.anyRequest()
			.authenticated()
			.and()
            .formLogin()
            .loginPage("/login")
            .loginProcessingUrl("/authenticate")
            .defaultSuccessUrl("/home")
            .successHandler(myAuthenticationSuccessHandler())
            .failureHandler(authenticationFailureHandler())
            .and()
			.logout()
			.logoutUrl("/logout-url")
			.logoutSuccessHandler(logoutSuccessHandler())
			.invalidateHttpSession(true)
			.deleteCookies("JSESSIONID")
			.permitAll();
		
		
		
		
			
	}
	@Bean
	public AuthenticationFailureHandler authenticationFailureHandler() {
		return new MyAuthenticationFailureHandler();
	}
	@Bean
	public LogoutSuccessHandler logoutSuccessHandler() {
		return new MyLogoutSuccessHandler();
	}

	@Bean
	public AuthenticationSuccessHandler myAuthenticationSuccessHandler() {
		return new MySimpleUrlAuthenticationHandler();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//		auth.inMemoryAuthentication().
//		withUser("sagir").password("{noop}password").roles("USER").
//		and().
//		withUser("sahil").password("{noop}password").roles("USER");
		
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());	
		//auth.authenticationProvider(authenticationProvider);
		//for use authentication provider user authenticationProvider
	
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}

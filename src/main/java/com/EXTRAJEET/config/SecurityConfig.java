package com.EXTRAJEET.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.EXTRAJEET.JWTutil;
import com.EXTRAJEET.filter.AuthTokenfilter;
import com.EXTRAJEET.userService.UserDetailService;

@Configuration
public class SecurityConfig {
	@Autowired
	AuthTokenfilter tokenfilter;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
	
	return httpSecurity.csrf( csrf->csrf.disable())
			.authorizeHttpRequests(Auth->Auth.requestMatchers("/api/save").permitAll()
					.requestMatchers("/h2-console/**").permitAll()
					.anyRequest().authenticated()
					)
			.headers(headers -> headers.frameOptions(frame -> frame.disable()))
	        .formLogin(form -> form.permitAll())
	        .addFilterBefore(tokenfilter, UsernamePasswordAuthenticationFilter.class)
			.build();
			
}
	@Bean
	public PasswordEncoder encoder () {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public UserDetailsService userDetailsService () {
		return new UserDetailService();
	}
@Bean	
public 	AuthenticationManager authenticationManager (UserDetailsService userDetailsService , PasswordEncoder encoder ) {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(encoder());
		daoAuthenticationProvider.setUserDetailsService(userDetailsService());
		return new  ProviderManager(daoAuthenticationProvider);
	}
}

package com.EXTRAJEET.filter;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.EXTRAJEET.JWTutil;
import com.EXTRAJEET.repository.UserRepository;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthTokenfilter  extends OncePerRequestFilter{

	private final Logger log =LoggerFactory.getLogger(AuthTokenfilter.class);
	@Autowired
	JWTutil jwTutil;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		log.info(request.toString());			
String authToken = request.getHeader("Authorization");
log.info(authToken);
if(authToken != null && authToken.startsWith("Bearer ")) {
	authToken= authToken.substring(7);
  Claims claims = jwTutil.extraction(authToken);
  String userName = claims.getSubject();
  UserDetails userDetails = userRepository.findByUsername(userName).orElseThrow();
  if(jwTutil.validateToken(claims, userDetails)){
	UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken( userDetails,null, userDetails.getAuthorities() );
	token.setDetails( new WebAuthenticationDetailsSource().buildDetails(request));
	
	SecurityContextHolder.getContext().setAuthentication(token);
	 
	  
	  
  }
  filterChain.doFilter(request, response);
  
  
}
		
	}


}

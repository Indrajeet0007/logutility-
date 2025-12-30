package com.EXTRAJEET;

import java.util.Date;

import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTutil {
	private final long EXPIRATION_TIME= 1000*60*60*10;
	private final String key ="a-string-secret-at-least-256-bits-long";
	private final SecretKey secretKey = Keys.hmacShaKeyFor(key.getBytes());
	private static final Logger log = LoggerFactory.getLogger(JWTutil.class);
public String tokenGeneration (String username) {
	return Jwts.builder().setSubject(username)
			.setIssuedAt(new Date())
			.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
			.signWith(secretKey, SignatureAlgorithm.HS256)
			.compact();
}
public Claims extraction (String token) {
	return Jwts
			.parserBuilder()
			.setSigningKey(secretKey)
			.build()
			.parseClaimsJws(token)
			.getBody();
	
}


public boolean validateToken(Claims claims,  UserDetails user) {
	if(!claims.isEmpty()) {
		log.info(claims.toString());		
		log.info("claims.getSubject()"+claims.getSubject());
		log.info("user.getUsername()"+user.getUsername());
	}
	if(!claims.isEmpty() && claims.getExpiration().after(new Date()) && claims.getSubject().equals(user.getUsername())) {
		return true;
	}
	
	return false;
}
	
}

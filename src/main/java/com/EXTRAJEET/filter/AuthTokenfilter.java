package com.EXTRAJEET.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import com.EXTRAJEET.JWTutil;
import com.EXTRAJEET.repository.UserRepository;

import io.jsonwebtoken.Claims;
import reactor.core.publisher.Mono;

@Component
public class AuthTokenfilter implements WebFilter {

    private final Logger log = LoggerFactory.getLogger(AuthTokenfilter.class);

    @Autowired
    JWTutil jwTutil;

    @Autowired
    UserRepository userRepository;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

        String authHeader = exchange.getRequest()
                .getHeaders()
                .getFirst(HttpHeaders.AUTHORIZATION);

        log.info("Auth Header: {}", authHeader);

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return chain.filter(exchange);
        }

        String token = authHeader.substring(7);

        Claims claims = jwTutil.extraction(token);
        String username = claims.getSubject();

        return userRepository.findByUsername(username)
                .flatMap(userDetails -> {

                    if (jwTutil.validateToken(claims, userDetails)) {

                        UsernamePasswordAuthenticationToken auth =
                                new UsernamePasswordAuthenticationToken(
                                        userDetails,
                                        null,
                                        userDetails.getAuthorities()
                                );

                        return chain.filter(exchange)
                                .contextWrite(ReactiveSecurityContextHolder.withAuthentication(auth));
                    }

                    return chain.filter(exchange);
                });
    }
}
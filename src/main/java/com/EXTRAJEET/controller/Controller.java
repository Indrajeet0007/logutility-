package com.EXTRAJEET.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EXTRAJEET.JWTutil;
import com.EXTRAJEET.LOGService.LogMux;
import com.EXTRAJEET.entities.Logs;
import com.EXTRAJEET.entities.TransactionDetails;
import com.EXTRAJEET.entities.UserDetail;
import com.EXTRAJEET.userService.UserDetailService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class Controller {
	private final Logger log = LoggerFactory.getLogger(Controller.class);
	@Autowired
	UserDetailService userDetailService;
	@Autowired
	JWTutil jwTutil;
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	LogMux logMux;

	@GetMapping(value ="/getLogs/{TXNID}", produces = org.springframework.http.MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Logs> getlogs(@PathVariable String TXNID) {
		return logMux.getlogs(TXNID);
	}

	@GetMapping(value ="/getAll" , produces = org.springframework.http.MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<UserDetail> getAllUsers() {
		 return userDetailService.getAll()
		            .delayElements(java.time.Duration.ofSeconds(1));
	}

	@PostMapping("/save")
	public String registerUser(@RequestBody UserDetail userDetail) {
		log.info(userDetail.toString());
		userDetailService.saveUser(userDetail);
		return "Restered";
	}

	@PostMapping("/getToken")
	public String getToken(@RequestBody UserDetail userDetail) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(userDetail.getUsername(), userDetail.getPassword()));
		return jwTutil.tokenGeneration(userDetail.getUsername());
	}
	
	@PostMapping("/getLogs")
	public Logs getLogs(@RequestBody TransactionDetails transactionDetails) {
		
		return logMux.getlogs(transactionDetails);
	}
}

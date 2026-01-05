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

	@GetMapping("/getLogs/{TXNID}")
	public Logs getlogs(@PathVariable String TXNID) {
		return logMux.getlogs(TXNID);
	}

	@GetMapping("/getAll")
	public List<UserDetail> getAllUsers() {
		return userDetailService.getAll();
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

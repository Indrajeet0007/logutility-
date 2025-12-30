package com.EXTRAJEET.userService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.EXTRAJEET.entities.UserDetail;
import com.EXTRAJEET.repository.UserRepository;

@Service
public class UserDetailService implements UserDetailsService {
	private final Logger log= LoggerFactory.getLogger(UserDetailService.class);
	@Autowired
	UserRepository userRepository;
	public void saveUser(UserDetail userDetail) {
		userDetail.setPassword(new BCryptPasswordEncoder().encode(userDetail.getPassword()));
		log.info(userDetail.toString());
		userRepository.save(userDetail);
	}
	
	public List<UserDetail> getAll() {
		return userRepository.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("EMPLOYEEE NOT FOUND"));
	}

}

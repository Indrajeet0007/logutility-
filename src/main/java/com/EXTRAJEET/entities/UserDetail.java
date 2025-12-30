package com.EXTRAJEET.entities;


import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.EXTRAJEET.enums.Team;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class UserDetail implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String username;
	private String password;
	@Enumerated(EnumType.STRING)
	private Team team;

//private final Logger log = LoggerFactory.getLogger(UserDetail.class);

@Override
	public String toString() {
		return "UserDetail [id=" + id + ", username=" + username + ", password=" + password + ", team=" + team + "]";
	}
public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		Set<SimpleGrantedAuthority> authortise = new HashSet<SimpleGrantedAuthority>();
		authortise.add(new SimpleGrantedAuthority(team.name()));
		System.out.println(authortise.toString());
		authortise.addAll(team.getPermissions().stream().map(x-> new SimpleGrantedAuthority(x.name())).collect(Collectors.toList()));
//		log.info(authortise.toString());
		System.out.println(authortise.toString());
		return authortise;
	}



}

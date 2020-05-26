package com.river.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService{

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("admin".equals(username)) {
			return new User("admin", "$2y$12$YXzNqdrrY/MGmp2LDf0HEeMoDOr8BmdN1l5W4pvzWREOk3MMxQJs2", (Collection<? extends GrantedAuthority>) new ArrayList<Object>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}

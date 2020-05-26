package com.river.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.river.dao.UserDao;
import com.river.model.UserDTO;

@Service
public class JwtUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;
	

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		com.river.model.User user = userDao.findByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),new ArrayList<>());
	}
	
	public com.river.model.User save(UserDTO user) {
		com.river.model.User newUser = new com.river.model.User();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userDao.save(newUser);
	}
}

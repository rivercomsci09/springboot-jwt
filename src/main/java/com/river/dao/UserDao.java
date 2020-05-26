package com.river.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.river.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer>{
	
	User findByUsername(String username);
}

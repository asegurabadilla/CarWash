package com.carwash.mvc.dao;

import org.springframework.stereotype.Repository;

import com.carwash.mvc.model.User;

@Repository
public interface LoginDAO {
	
	public User validateLoginDAO(String usr, String pass);
	public void deleteUserDAO(User user);
	public void addUserDAO(User user);
}

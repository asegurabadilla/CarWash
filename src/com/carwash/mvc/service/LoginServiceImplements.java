package com.carwash.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.mvc.dao.LoginDAO;
import com.carwash.mvc.model.User;

@Service
public class LoginServiceImplements implements LoginService{

	@Autowired
	LoginDAO loginDAO;
	
	public User validaLoginService(String usr,String pass){
		return loginDAO.validateLoginDAO(usr, pass);
	}
	public void deleteUserService(User user){
		loginDAO.deleteUserDAO(user);
	}
	public void addUserService(User user){
		loginDAO.addUserDAO(user);
	}


}

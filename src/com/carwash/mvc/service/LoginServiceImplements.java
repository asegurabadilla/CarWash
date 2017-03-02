package com.carwash.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.mvc.dao.LoginDAO;

@Service
public class LoginServiceImplements implements LoginService{
	
	@Autowired
	LoginDAO loginDAO;
	
	public boolean validaLoginService(String usr,String pass){
		return loginDAO.validateLoginDAO(usr, pass);
	}


}

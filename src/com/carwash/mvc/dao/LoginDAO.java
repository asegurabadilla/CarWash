package com.carwash.mvc.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface LoginDAO {
	
	public boolean validateLoginDAO(String usr, String pass);
}

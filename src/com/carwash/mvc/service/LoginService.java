/**
 * 
 */
package com.carwash.mvc.service;

import com.carwash.mvc.model.User;

/**
 * @author Allen
 *
 */

public interface  LoginService{
	public User validaLoginService(String usr,String pass);
	public void deleteUserService(User user);
	public void addUserService(User user);
}

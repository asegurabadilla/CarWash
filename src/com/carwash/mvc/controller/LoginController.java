
package com.carwash.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.carwash.mvc.model.User;
import com.carwash.mvc.service.LoginService;


/**
 * @author Allen
 *
 */

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	 @RequestMapping(value = "/Login", method = RequestMethod.POST)
	   public ModelAndView login(HttpServletRequest request,HttpServletRequest response){
		 String pass = request.getParameter("pass");
		 String user = request.getParameter("user");
		 
		 User usr = null;
		 ModelAndView modelAndView = new ModelAndView();
		 usr = loginService.validaLoginService(user, pass);
		 if(usr != null){ 
			 modelAndView.addObject("user", usr);
			 modelAndView.setViewName("main.jsp");
		 }
		 else{
			 modelAndView.addObject("message","Usuario no valido");
			 modelAndView.setViewName("index.jsp");
		 }
		 return modelAndView;
	 }
	 
	 @RequestMapping(value ="/Change", method = RequestMethod.GET)
	   public ModelAndView change(){
		 ModelAndView modelAndView = new ModelAndView();
		 modelAndView.addObject("message","Password Changed");
		 modelAndView.setViewName("/WEB-INF/Login/Change.jsp");
		 return modelAndView;
	 }
	 
	 @RequestMapping(value ="/Delete", method = RequestMethod.GET)
	 public ModelAndView delete(@RequestParam("user") int user){
		 ModelAndView modelAndView = new ModelAndView();
		 modelAndView.addObject("message","User Id: "+user+" Elimanated");
		 User usr = new User();
		 usr.setUserId(user);
		 loginService.deleteUserService(usr);
		 modelAndView.setViewName("/main.jsp");
		 return modelAndView;
	 }
	 
	 @RequestMapping(value ="/Add", method = RequestMethod.GET)
	 public ModelAndView add(){
		 ModelAndView modelAndView = new ModelAndView();
		 modelAndView.addObject("message","User Id: .l. added");
		 loginService.addUserService(new User());
		 modelAndView.setViewName("/main.jsp");
		 return modelAndView;
	 }
}

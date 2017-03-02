
package com.carwash.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	   public ModelAndView login(@RequestParam("user") String user, @RequestParam("pass") String pass){
		 ModelAndView modelAndView = new ModelAndView();
		 boolean activo= loginService.validaLoginService(user, pass);
		 if(activo)
			 modelAndView.setViewName("main.jsp");
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
}

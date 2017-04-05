package com.carwash.mvc.dao;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.carwash.mvc.model.Role;
import com.carwash.mvc.model.User;



public class LoginDAOImplements extends Connection implements LoginDAO{
	final static Logger logger = Logger.getLogger(LoginDAOImplements.class);

	
	public User validateLoginDAO(String usr,String pass){
		User user = null;
		try{  
			Session session = getCurrentSession().openSession();
			Transaction trans = session.beginTransaction();
			Query query = session.createQuery("select U from User U where U.password=:pass and U.userName=:usr");
			query.setString( "pass",pass);
			query.setString("usr",usr);   
			user = (User) query.uniqueResult();
			trans.commit();			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return user;
	}
	
	
	public void deleteUserDAO(User user){
		try{  
			Session session = getCurrentSession().openSession();
			Transaction trans = session.beginTransaction();
			session.delete(user);
			trans.commit();			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	public void addUserDAO(User usr){
		try{  	
			Session session = getCurrentSession().openSession();
			Transaction trans = session.beginTransaction();
			
			User user = new User();
			user.setModifPassword(1);
			user.setPassword("1234"); 
			user.setUserName("lis");
			user.setCreationDate(new Timestamp(0));
			user.setFinalLoginDate(new Timestamp(0));
			user.setUserId(1);
			
			Role role = new Role();
			role.setRol("admin");
			role.setRoleNum(0001);
			role.setUser(user);
			
			Role role1 = new Role();
			role1.setRol("reader");
			role1.setRoleNum(0002);
			role1.setUser(user);
			 
			Role role2 = new Role();
			role2.setRol("deleter");
			role2.setRoleNum(0003);
			role2.setUser(user);
			
			Set<Role> a = new HashSet<Role>();
			a.add(role);
			a.add(role1);
			a.add(role2);
			user.setRole(a);
			
			session.saveOrUpdate(user);
			trans.commit();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}	
		
}

package com.carwash.mvc.dao;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;



public class LoginDAOImplements extends Connection implements LoginDAO{
	
	final static Logger logger = Logger.getLogger(LoginDAOImplements.class);

	@Transactional
	public boolean validateLoginDAO(String usr,String pass){
		boolean result = false;  
		Query query;
		query =  sessionFactory.getCurrentSession().createSQLQuery("SELECT sp_usuario(:op,:modo,:usuario,:password)")
				.setParameter("op", 'C')
				.setParameter("modo",1)
				.setParameter("usuario", usr)
				.setParameter("password", pass);
		result = (boolean) query.uniqueResult();
		
		return result; 
	}
}

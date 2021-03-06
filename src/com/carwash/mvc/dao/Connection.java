
package com.carwash.mvc.dao;

import java.sql.SQLException;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/** 
 * @author Allen
 *
 */
public abstract class Connection {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public SessionFactory getCurrentSession() throws SQLException{
		return  sessionFactory;
	}
}

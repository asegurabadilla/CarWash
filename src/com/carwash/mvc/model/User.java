package com.carwash.mvc.model;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * @author Allen SB
 *
 */


@Entity
@Table(name="User")
public class User implements Serializable {
	
	private static final long serialVersionUID = 3343777832042318011L;
	private Set<Role> role;
	private int userId;
	private String userName;
	private Timestamp creationDate;
	private String password;
	private Timestamp  finalLoginDate;
	private int modifPassword;
	
	public User(){}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userId",insertable = false, updatable = false)
	public int getUserId() {
		return userId;
	}

	//unique=true
	@Column(name="userName", length=30)
	public String getUserName() {
		return userName;
	}
	
	@Column(name="creationDate")
	public Timestamp getCreationDate() {
		return creationDate;
	}
	
	@Column(name="password", length=20)
	public String getPassword() {
		return password;
	}
	
	@Column(name="finalLoginDate")
	public Timestamp getFinalLoginDate() {
		return finalLoginDate;
	}
	
	@Column(name="modifPassword")
	public int getModifPassword() {
		return modifPassword;
	}
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="user", fetch=FetchType.EAGER)	
	public Set<Role> getRole(){
		return role;
	}
	

	public void setUserId(int userId) {
		this.userId = userId;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	
	public void setPassword(String password) {
		this.password = password;
	}


	public void setFinalLoginDate(Timestamp finalLoginDate) {
		this.finalLoginDate = finalLoginDate;
	}
	

	public void setModifPassword(int modifPassword) {
		this.modifPassword = modifPassword;
	}

	public void setRole(Set<Role> a) {
		this.role = a;
	}

}

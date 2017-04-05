/**
 * 
 */
package com.carwash.mvc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * @author Allen SB
 *
*/

@Entity
@Table(name="Role")
public class Role implements Serializable{
	
	private static final long serialVersionUID = -7872351820594421211L;
	private User user;
	private int idRol;
	private String rol;
	private int roleNum;
	
	public Role(){}
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idRol")
	public int getIdRol() {
		return idRol;
	}
	
	@Column(name="rol")
	public String getRol() {
		return rol;
	}
	
	@Column(name="roleNum")
	public int getRoleNum() {
		return roleNum;
	}
	
	@ManyToOne
	@JoinColumn(name="userId")
	public User getUser(){
		return user;
	}
	

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public void setRoleNum(int roleNum) {
		this.roleNum = roleNum;
	}

	public void setUser(User user) {
		this.user = user;
	}
}

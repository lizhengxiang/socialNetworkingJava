package com.g7love.beans.permissions;

import java.io.Serializable;

public class UserBean implements Serializable {

	private String username;
	private String password;
	public UserBean() {
		super();
	}
	public UserBean(Integer id, String username, String password, Double account) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

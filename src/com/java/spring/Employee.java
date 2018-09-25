package com.java.spring;

public class Employee {
	
	String username;
	String password;
	int id;

	@Override
	public String toString() {
		return "Employee [username=" + username + ", password=" + password + ", id=" + id + "]";
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
		
}

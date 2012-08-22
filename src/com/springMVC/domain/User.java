package com.springMVC.domain;

/**
 * 
 * @author adiaz
 * Bean that represents a user.
 */

public class User {

	/**
	 * Default constructor.
	 */
	public User(){
		super();
	}
	/**
	 * Instanciate a new user form a string with the format: name|surname|email|userName|password....
	 * @param userStr
	 */
	public User(String userStr){
		String[] split = userStr.split("\\|");
		name = split[0];
		surname = split[1];
		email = split[2];
		userName = split[3];
		password = split[4];
	}
	
	private String name;
	private String surname;
	private String email;
	private String userName;
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return name + "|" + surname + "|" + email + "|" + userName + "|" + password;
	}	
	
	
}

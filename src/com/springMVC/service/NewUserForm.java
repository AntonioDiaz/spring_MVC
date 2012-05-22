package com.springMVC.service;

import com.springMVC.domain.User;

/**
 * 
 * @author adiaz
 * Form used to create a new user. 
 * Reuse of user bean.
 */
public class NewUserForm extends User {

	private String repeatPassword;
	
	public String getRepeatPassword() {
		return repeatPassword;
	}
	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
	
	
}

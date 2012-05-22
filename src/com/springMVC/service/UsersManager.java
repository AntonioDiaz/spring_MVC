package com.springMVC.service;

/**
 * 
 * @author adiaz
 * Interface declares the operations with users.
 *  
 */
public interface UsersManager {

	public boolean checkPassword(String userName, String password);
	
	public boolean existingUserName(String userName);
	
	public boolean addUser(NewUserForm user);
}

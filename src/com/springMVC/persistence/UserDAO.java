package com.springMVC.persistence;

import com.springMVC.domain.User;

/**
 * 
 * @author adiaz
 * Interface to manipulate and access user information.
 */
public interface UserDAO {
	
	/**
	 * Check if an user exists.
	 * @param userName
	 * @return
	 */
	public User checkUserName(String userName);
	
	/**
	 * Persist an user if it did not exist before.
	 * @param user
	 * @return
	 */
	public boolean saveUser(User user);

}

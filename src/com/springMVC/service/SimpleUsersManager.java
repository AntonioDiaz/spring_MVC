package com.springMVC.service;

import com.springMVC.domain.User;
import com.springMVC.persistence.UserDAO;

/**
 * 
 * @author adiaz
 * Clase that manage with users.
 */
public class SimpleUsersManager implements UsersManager {

	private UserDAO userDao;
	
	@Override
	public boolean checkPassword(String userName, String password) {
		User user = userDao.checkUserName(userName);
		boolean correct = false;
		if (user!=null && password.equals(user.getPassword())){
			correct = true;
		}
		return correct;
	}

	@Override
	public boolean addUser(NewUserForm user) {
		return userDao.saveUser(user);
	}

	@Override
	public boolean existingUserName(String userName) {
		return userDao.checkUserName(userName)!=null;
	}
	
	
	public UserDAO getUserDao() {
		return userDao;
	}
	
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

}

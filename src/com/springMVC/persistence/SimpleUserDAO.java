package com.springMVC.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.springMVC.domain.User;

/**
 * 
 * @author adiaz
 * Implementation of UserDao that simulates de access to a BBDD, the information are persisted on file. 
 * Attribute dataSourceFile indicates the path of that file. 
 * 
 */

public class SimpleUserDAO implements UserDAO, ApplicationContextAware {
	
	private String dataSourceFile;
	
	@Override
	public User checkUserName(String userName) {
		User myUser = null;
		try {
			InputStream resourceAsStream = this.applicationContext.getResource(dataSourceFile).getInputStream();
			InputStreamReader in = new InputStreamReader(resourceAsStream);
			BufferedReader buffer = new BufferedReader(in);
			String line;
			while ((line = buffer.readLine())!=null && myUser==null) {
				User userTemp = new User(line);
				if (userTemp.getUserName().equals(userName)){
					myUser = userTemp;
				}
			}
			resourceAsStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return myUser;
	}

	@Override
	public boolean saveUser(User user) {
		if (this.checkUserName(user.getUserName()) == null) {
			try {
				File file = this.applicationContext.getResource(dataSourceFile).getFile();
				FileWriter fileWriter = new FileWriter(file, true);
				BufferedWriter out = new BufferedWriter(fileWriter);
				out.write(user.toString() + "\n");
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * 
	 * @return
	 */
	public String getDataSourceFile() {
		return dataSourceFile;
	}

	/**
	 * 
	 * @param dataSourceFile
	 */
	public void setDataSourceFile(String dataSourceFile) {
		this.dataSourceFile = dataSourceFile;
	}
	
	/** Used to access WEB-INF directory */
	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		
	}

}

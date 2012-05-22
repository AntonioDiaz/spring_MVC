package com.springMVC.controllers;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.springMVC.service.LoginForm;
import com.springMVC.service.UsersManager;

/**
 * 
 * @author adiaz
 * Controller to validate user names and passwords.
 */
public class LoginFormController extends SimpleFormController {

	private UsersManager usersManager;
	
	@Override
	protected ModelAndView onSubmit(Object command, BindException errors) throws Exception {
		String userName = ((LoginForm) command).getUserName();
		String password = ((LoginForm) command).getPassword();
		ModelAndView modelAndView;
		if (this.usersManager.checkPassword(userName, password)) {
			modelAndView = new ModelAndView(new RedirectView(getSuccessView()));
		} else {
			modelAndView = new ModelAndView(getFormView(), "startUserSession", command);
			errors.rejectValue("password", "error.user-incorrect", null, "Password incorrect");
			modelAndView.addAllObjects(errors.getModel());
		}
		return modelAndView;
	}

	/**
	 * 
	 */
	public UsersManager getUsersManager() {
		return usersManager;
	}

	/**
	 * 
	 * @param usersManager
	 */
	public void setUsersManager(UsersManager usersManager) {
		this.usersManager = usersManager;
	}
}

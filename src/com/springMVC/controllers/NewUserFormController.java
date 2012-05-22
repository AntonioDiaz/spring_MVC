package com.springMVC.controllers;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.springMVC.service.NewUserForm;
import com.springMVC.service.UsersManager;

/**
 * @author adiaz
 * Controller to create news users.
 */
public class NewUserFormController extends SimpleFormController {

	private UsersManager usersManager;
	
	@Override
	protected ModelAndView onSubmit(Object command, BindException errors) throws Exception {
		ModelAndView modelAndView = null;
		NewUserForm newUserForm = (NewUserForm)command;
		if (usersManager.existingUserName(newUserForm.getUserName())){
			modelAndView = new ModelAndView(getFormView(), "startUserSession", command);
			errors.rejectValue("userName", "error.user-exists", null, "User Exists");
			modelAndView.addAllObjects(errors.getModel());
		} else {
			usersManager.addUser((NewUserForm)command);
			modelAndView = new ModelAndView(new RedirectView(getSuccessView()));
		}
		return modelAndView;
	}

	public UsersManager getUsersManager() {
		return usersManager;
	}

	public void setUsersManager(UsersManager usersManager) {
		this.usersManager = usersManager;
	}
}

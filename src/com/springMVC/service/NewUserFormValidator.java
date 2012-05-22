package com.springMVC.service;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * 
 * @author adiaz
 * Validate the new user form.
 */
public class NewUserFormValidator implements Validator {

	@SuppressWarnings("rawtypes")
	@Override
	public boolean supports(Class myClass) {
		return NewUserForm.class.equals(myClass);
	}

	@Override
	public void validate(Object object, Errors errors) {
		NewUserForm newUserForm = (NewUserForm)object;
		if (!StringUtils.hasText(newUserForm.getName())){
			errors.rejectValue("name", "error.required", null, "Field required.");
		}
		if (!StringUtils.hasText(newUserForm.getSurname())){
			errors.rejectValue("surname", "error.required", null, "Field required.");
		}
		if (!StringUtils.hasText(newUserForm.getEmail())){
			errors.rejectValue("email", "error.required", null, "Field required.");
		}
		if (!StringUtils.hasText(newUserForm.getUserName())){
			errors.rejectValue("userName", "error.required", null, "Field required.");
		}
		if (!StringUtils.hasText(newUserForm.getPassword())){
			errors.rejectValue("password", "error.required", null, "Field required.");
		}
		if (!StringUtils.hasText(newUserForm.getRepeatPassword())){
			errors.rejectValue("repeatPassword", "error.required", null, "Field required.");
		}
		if (StringUtils.hasText(newUserForm.getPassword()) 
				&& StringUtils.hasText(newUserForm.getRepeatPassword()) 
				&& !newUserForm.getPassword().equals(newUserForm.getRepeatPassword())){
			errors.rejectValue("repeatPassword", "error.distinct_password", null, "Password does not macth.");
		}
		
	}

}

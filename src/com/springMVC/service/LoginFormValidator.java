/**
 * 
 */
package com.springMVC.service;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * 
 * @author adiaz
 * Validates the User login form.
 */
public class LoginFormValidator implements Validator {

	@SuppressWarnings("rawtypes")
	@Override
	public boolean supports(Class myClass) {
		return LoginForm.class.equals(myClass);
	}

	@Override
	public void validate(Object object, Errors errors) {
		LoginForm loginForm = (LoginForm)object;
		if (loginForm == null){
			errors.rejectValue("userName", "error.not-specified", null, "Error not specified.");
		} else {
			if (!StringUtils.hasText(loginForm.getUserName())){
				errors.rejectValue("userName", "error.required", null, "Field required.");
			}
			if (!StringUtils.hasText(loginForm.getPassword())){
				errors.rejectValue("password", "error.required", null, "Field required.");
			}
		}
	}
}

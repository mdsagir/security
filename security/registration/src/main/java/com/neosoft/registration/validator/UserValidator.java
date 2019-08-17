package com.neosoft.registration.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neosoft.registration.form.UserForm;
import com.neosoft.registration.service.IUserService;

@Component
public class UserValidator implements Validator {

	IUserService iUserService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz == UserForm.class;
	}

	@Override
	public void validate(Object target, Errors errors) {

		UserForm userForm=(UserForm)target;
		
		ValidationUtils.rejectIfEmpty(errors, "firstName", "user.first.name.empty");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "user.last.name.empty");
		ValidationUtils.rejectIfEmpty(errors, "email", "user.email.empty");

		if(iUserService.checkEmailExist(userForm.getEmail())) {
			errors.rejectValue("email", "user.email.exist");
		}
		
	
	}

	@Autowired
	public void setiUserService(IUserService iUserService) {
		this.iUserService = iUserService;
	}
}

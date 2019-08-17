package com.neosoft.registration.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.neosoft.registration.form.UserForm;
import com.neosoft.registration.validator.UserValidator;

@Controller
public class RegistrationController {

	private UserValidator userValidator;

	@GetMapping("user")
	public String registration(@ModelAttribute("user") UserForm user) {
		return "registration";
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(userValidator);
	}

	@PostMapping("user")
	public String userRegistration(@Valid @ModelAttribute("user") UserForm user, BindingResult result) {

		if (result.hasErrors()) {
			return "registration";
		}

		System.out.println("UserInfo: " + user);

		return "redirect:user";
	}

	@Autowired
	public void setUserValidator(UserValidator userValidator) {
		this.userValidator = userValidator;
	}

}

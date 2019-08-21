package com.neosoft.registration.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.neosoft.registration.entity.User;
import com.neosoft.registration.entity.VerificationToken;
import com.neosoft.registration.event.RegistrationComplateEvent;
import com.neosoft.registration.form.UserForm;
import com.neosoft.registration.service.IUserService;
import com.neosoft.registration.service.UserService;
import com.neosoft.registration.util.UserEnum;
import com.neosoft.registration.validator.UserValidator;

@Controller
public class RegistrationController {

	private ApplicationEventPublisher eventPublisher;
	private UserValidator userValidator;
    private HttpServletRequest servletContext;
    private IUserService service;

	@GetMapping("user")
	public String registration(@ModelAttribute("user") UserForm user) {
		return "registration";
	}

	@GetMapping("/")
	public String index() {
		return "redirect:user";
	}
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(userValidator);
	}

	@PostMapping("user")
	public String userRegistration(@Valid @ModelAttribute("user") UserForm userForm, 
			BindingResult result) {

		
		if (result.hasErrors()) {
			return "registration";
		}
		
		User user = service.registerUser(userForm);
		
		
		ServletUriComponentsBuilder contextPath = ServletUriComponentsBuilder.fromCurrentContextPath();
		String path = contextPath.toUriString();
		 
		eventPublisher.publishEvent(new RegistrationComplateEvent(user, LocaleContextHolder.getLocale() , path));

		System.out.println("UserInfo: " + user);


		return "redirect:user";
	}

	@GetMapping("regitrationConfirm")
	public String registrationConfirmation(@RequestParam("token") String token) {
		
		
		VerificationToken verificationToken = service.getVerificationToken(token);
		
		if(verificationToken==null) {
			// invalid token
			return "redirect:user";
		}
		
		User user = verificationToken.getUser();
		
		Calendar calendar=Calendar.getInstance();
		if((verificationToken.getExpiryDate().getTime()-calendar.getTime().getTime())<=0){
			// token expired
			
		}
		user.setEnable(UserEnum.USER_ENABLE.ENABLE.getValue());
		return "";
	}
	
	
	@Autowired
	public void setUserValidator(UserValidator userValidator) {
		this.userValidator = userValidator;
	}
	@Autowired
	public void setEventPublisher(ApplicationEventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}
	@Autowired
	public void setServletContext(HttpServletRequest servletContext) {
		this.servletContext = servletContext;
	}
	@Autowired
	public void setService(UserService service) {
		this.service = service;
	}
}

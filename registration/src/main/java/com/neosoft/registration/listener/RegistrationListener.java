package com.neosoft.registration.listener;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.neosoft.registration.entity.User;
import com.neosoft.registration.event.RegistrationComplateEvent;
import com.neosoft.registration.service.IUserService;

@Component
public class RegistrationListener implements ApplicationListener<RegistrationComplateEvent> {

	private MessageSource messageSource;
	private JavaMailSender javaMailSender;
	private IUserService userService;

	@Autowired
	private Environment env;

	@Override
	public void onApplicationEvent(RegistrationComplateEvent event) {

		this.confirmationRegistration(event);
	}

	private void confirmationRegistration(RegistrationComplateEvent event) {

		final User user = event.getUser();
		final String token = UUID.randomUUID().toString();
		userService.createVarifacationToken(user, token);
		
		final SimpleMailMessage email = constructEmailMessage(event, user, token);
        javaMailSender.send(email);

	}

	private final SimpleMailMessage constructEmailMessage(final RegistrationComplateEvent event, final User user,
			final String token) {
		final String recipientAddress = user.getEmail();
		final String subject = "Registration Confirmation";
		final String confirmationUrl = event.getUrl() + "/registrationConfirm.html?token=" + token;
		final String message = messageSource.getMessage("message.regSucc", null, event.getLocale());
		final SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText(message + " \r\n" + confirmationUrl);
		email.setFrom(env.getProperty("support.email"));
		return email;
	}

	@Autowired
	public void setiUserService(IUserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Autowired
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

}

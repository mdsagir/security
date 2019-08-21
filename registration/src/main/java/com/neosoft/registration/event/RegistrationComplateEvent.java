package com.neosoft.registration.event;

import java.util.Locale;

import org.springframework.context.ApplicationEvent;

import com.neosoft.registration.entity.User;

public class RegistrationComplateEvent extends ApplicationEvent {

	private static final long serialVersionUID = 4740984597346329140L;

	private String url;
	private Locale locale;
	private User user;

	public RegistrationComplateEvent(User user, Locale locale, String url) {
		
		super(user);

		this.locale = locale;
		this.url = url;
		this.user = user;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}

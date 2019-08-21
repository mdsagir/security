package com.neosoft.profile.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

	
	@GetMapping("home")
	public String home() {
		return "Home Resource";
	}
	@GetMapping("profile")
	public String profile() {
		return "Profile Resource";
	}
}

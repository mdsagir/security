package com.neosoft.SSLSpringBoot.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class HomeController {

	@GetMapping
	public String home() {
		
		List<String> list=new ArrayList<>();
		list.add("Mouse");
		list.add("Keyboard");
		String string = list.toString();
		
		return string;
		//return Arrays.asList("Apple iPhone X","Samsung glaxy S10").toString();
	}
}

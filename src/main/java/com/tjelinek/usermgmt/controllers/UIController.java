package com.tjelinek.usermgmt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UIController {

	@RequestMapping("/protected-users-page")
	public String protectedPage() {
		return "protected-users.html";
	}

	@RequestMapping("/")
	public String home() {
		return "home.html";
	}

}

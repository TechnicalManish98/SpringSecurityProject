package com.springsecurity.inmemoryauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String showHome(){
		return "homepage.html";
	}
	
	@GetMapping("/admin")
	public String showAdmin(){
		return "admin.html";
	}
	
	@GetMapping("/emp")
	public String showEmp(){
		return "emp.html";
	}
	
	@GetMapping("/student")
	public String showStudent(){
		return "student.html";
	}
	
	@GetMapping("/welcome")
	public String showWelcome(){
		return "welcome.html";
	}
	
	@GetMapping("/denied")
	public String showDenied(){
		return "denied.html";
	}
}

package com.tt.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class usercontroller {
	@GetMapping("/auth/joinForm")
	public String joinFrom() {
		return "users/joinForm";
	}
	@GetMapping("/auth/loginForm")
	public String loginFrom() {
		return "users/loginForm";
	}
	@GetMapping("/user/updateForm")
	public String updateForm() {
		return "user/updateForm";
	}
}

package com.books.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.books.model.User;
import com.books.model.UserDTO;
import com.books.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping(value = "/signin")
	public User login(@RequestBody UserDTO userLogin, HttpSession session) {
		try {
			User user = loginService.login(userLogin);
			if(user != null){
				// Set time out for session with 30m
				session.setMaxInactiveInterval(1800);
			}

			return user;
		} catch (Exception e) {
			return null;
		}
	}
}

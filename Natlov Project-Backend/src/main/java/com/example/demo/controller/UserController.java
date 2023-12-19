package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.UserAuthenticationProvider;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@CrossOrigin("*")
@RestController("/User")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserAuthenticationProvider userAuthenticationProvider;

	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		// System.out.println("This method was hit");
		User user1 = userService.adduser(user);
		user1.setToken(userAuthenticationProvider.createtoken(user.getEmail()));
		return ResponseEntity.ok(user1);

	}

	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody User user) {
		// System.out.println("This method was hit");
		User user1 = userService.loginUser(user);
		user1.setToken(userAuthenticationProvider.createtoken(user.getEmail()));
		return ResponseEntity.ok(user1);

	}

	
}

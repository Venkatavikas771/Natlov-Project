package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userrepo;
	@Autowired
	private PasswordEncoder passwordencoder;

	public User adduser(User user) {
		user.setPassword(passwordencoder.encode(user.getPassword()));
		if (userrepo.save(user) != null) {
			return user;
		}
		return null;
	}

	public User loginUser(User user) {
		User user1 = userrepo.findByEmail(user.getEmail());
		if (passwordencoder.matches(user.getPassword(), user1.getPassword())) {
			return user;
		}
		return null;
	}

	public User findByEmail(String email) {
		return userrepo.findByEmail(email);
	}

		
}

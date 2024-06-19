package com.springrest.bankingedge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.bankingedge.entity.User;
import com.springrest.bankingedge.service.UserService;
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService service;

	// create the user
	@PostMapping("/create")
	public ResponseEntity<User> createAccount(@RequestBody User user) {
		User createUser = service.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(createUser);
	}
}

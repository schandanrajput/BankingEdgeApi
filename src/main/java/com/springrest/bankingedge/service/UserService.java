package com.springrest.bankingedge.service;

import com.springrest.bankingedge.entity.User;

public interface UserService {
	public User createUser(User user);

	public User login(String email, String password);

	boolean existsByEmail(String email);


}

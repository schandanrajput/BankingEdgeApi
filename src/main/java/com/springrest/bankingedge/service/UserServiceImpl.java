package com.springrest.bankingedge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.bankingedge.entity.User;
import com.springrest.bankingedge.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepo repository;

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		User user_saved = repository.save(user);

		return user_saved;
	}

	@Override

	public User login(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsByEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

}

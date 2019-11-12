package com.mywebprojet.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.mywebprojet.springboot.entity.User;
import com.mywebprojet.springboot.mapper.UserMapper;
import com.mywebprojet.springboot.service.UserService;

public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public void insert(User user) {
		userMapper.insert(user);
	}
	
	
}
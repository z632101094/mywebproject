package com.mywebprojet.springboot.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mywebprojet.springboot.entity.User;

@Service
public interface UserService{
	
	void insert(User user);
	
}

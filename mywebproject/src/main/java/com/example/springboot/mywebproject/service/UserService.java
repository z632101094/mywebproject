package com.example.springboot.mywebproject.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springboot.mywebproject.entity.User;

@Service
public interface UserService extends BaseService<User>{
	User selectByUsername(String username);
}

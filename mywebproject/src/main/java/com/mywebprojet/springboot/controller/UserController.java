package com.mywebprojet.springboot.controller;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mywebprojet.springboot.entity.User;
import com.mywebprojet.springboot.mapper.UserMapper;
import com.mywebprojet.springboot.service.UserService;
@RestController
@RequestMapping(value = "user")
public class UserController {
	@Autowired
	private UserMapper userMapper;
	//@Autowired
	//private UserService userService;
	
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(User user) {
    	if (userMapper.getById(user) != null)
    		return "False";
    	userMapper.insert(user);
    	return "SUCCESS";
    }
}
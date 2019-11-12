package com.mywebproject.controller;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mywebproject.entity.User;
import com.mywebproject.mapper.UserMapper;
import com.mywebproject.service.UserService;
@RestController
@RequestMapping(value = "user")
public class UserController {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserService userService;
	
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(String userName, String password, String rePassword) {
    	
    	if (!password.equals(rePassword)) return "not equal";
    	User user = new User();
    	user.setId(5);
    	user.setUserName(userName);
    	user.setPassword(password);
    	if (userService.selectByUserName(user.getUserName()) != null) return "Same UserName";
    	int result = userService.save(user);
    	if (result == 1) return "SUCCESS";
    	else return "False";
    }
}
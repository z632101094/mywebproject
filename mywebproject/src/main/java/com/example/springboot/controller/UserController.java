package com.example.springboot.controller;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.User;
import com.example.springboot.mapper.UserMapper;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserMapper userMapper;
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(User user) {
    	user.setUserName(user.getUserName());
    	user.setPassword(user.getPassord());
    	userMapper.insert(user);
    	return "SUCCESS";
    }
}
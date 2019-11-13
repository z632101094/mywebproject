package com.mywebproject.controller;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mywebproject.entity.User;
import com.mywebproject.reponse.Result;
import com.mywebproject.service.UserService;

import net.minidev.json.JSONObject;
@RestController
@RequestMapping(value = "user")
public class UserController {
	@Autowired
	private UserService userService;
	
    /**

     */
    @RequestMapping(value = "checkUserName", method = RequestMethod.POST)
    public String checkUserName(String userName) {
    	System.out.print(userName+"\n");
    	User user = new User();
    	user.setUserName(userName);
    	if (userService.selectByUserName(user.getUserName()) != null) return "Already exist";
    	else return "Not exist";
    }
    /**

     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public Object register(@RequestBody User user) {
    	if (userService.selectByUserName(user.getUserName()) != null) {
            String message ="Username already exist";
            return Result.fail(message);
    	}
    	int result = userService.save(user);
    	if (result == 1) {
            String message ="Register successfully";
            return Result.success(message);
    	}
    	else {
            String message ="Unknown failing";
            return Result.fail(message);
    	}
    }
}
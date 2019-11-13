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
import com.mywebproject.reponse.ApiResult;
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
    public ApiResult register(@RequestBody User user) {
        ApiResult apiResult = new ApiResult();
    	if (userService.selectByUserName(user.getUserName()) != null) {
            apiResult.setSuccess(false);
            apiResult.setCode(-1);
            apiResult.setMessage("Username already exist");
    		return apiResult;
    	}
    	int result = userService.save(user);
    	if (result == 1) {
            apiResult.setSuccess(true);
            apiResult.setCode(0);
            apiResult.setMessage("Register successfully");
    		return apiResult;
    	}
    	else {
            apiResult.setSuccess(false);
            apiResult.setCode(-1);
            apiResult.setMessage("Unknown");
    		return apiResult;
    	}
    }
}
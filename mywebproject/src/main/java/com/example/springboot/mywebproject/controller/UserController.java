package com.example.springboot.mywebproject.controller;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.mywebproject.entity.User;
import com.example.springboot.mywebproject.reponse.ApiResult;
import com.example.springboot.mywebproject.reponse.Result;
import com.example.springboot.mywebproject.service.UserService;

import net.minidev.json.JSONObject;
@RestController
@RequestMapping(value = "user")
public class UserController {
	@Autowired
	private UserService userService;
	
    /**

     */
    /*@RequestMapping(value = "login", method = RequestMethod.POST)
    public Object checkUsername(@RequestBody User user) {
    	if (userService.selectByUsername(user.getUsername()) != null) {
            String message ="Sign-in Successfully";
            return Result.success(message);
    	}
    	else {
            String message ="Username or password wrong";
            return Result.fail(message);
    	}
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public Object register(@RequestBody User user) {
    	if (userService.selectByUsername(user.getUsername()) != null) {
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
    }*/
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ApiResult checkUsername(@RequestBody User user) {
        ApiResult apiResult = new ApiResult();
    	if (userService.selectByUsername(user.getUsername()) != null) {
            apiResult.setSuccess(true);
            apiResult.setCode(0);
            apiResult.setMessage("Sign-in Successfully");
            return apiResult;
    	}
    	else {
            apiResult.setSuccess(false);
            apiResult.setCode(-1);
            apiResult.setMessage("Username or password wrong");
            return apiResult;
    	}
    }
    /**

     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ApiResult register(@RequestBody User user) {
        ApiResult apiResult = new ApiResult();
    	if (userService.selectByUsername(user.getUsername()) != null) {
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
            apiResult.setMessage("Unknown failing");
            return apiResult;
    	}
    }
    
    
    @RequestMapping(value = "id", method = RequestMethod.POST)
    public ApiResult getById(Integer id) {
    	System.out.print(id);
        ApiResult apiResult = new ApiResult();
        User user =  userService.get(id);
        if (user == null) {
            apiResult.setSuccess(false);
            apiResult.setCode(-1);
            apiResult.setMessage("Input id doesn't exist");
            return apiResult;
        }
    	else {
            apiResult.setSuccess(true);
            apiResult.setCode(0);
            apiResult.setMessage("Return Success");
            apiResult.setData(user);
            return apiResult;
    	}
    }
    
}
package com.example.springboot.mywebproject.service.impl;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.mywebproject.dao.UserDao;
import com.example.springboot.mywebproject.entity.User;
import com.example.springboot.mywebproject.request.UserRequest;
import com.example.springboot.mywebproject.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Resource
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }
    @Resource
    public void setBaseDao(UserDao userDao) {
        super.setBaseDao(userDao);
    }
	@Override
	public User selectByUsername(String username) {
		
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername(username);
        return userDao.selectByUsername(userRequest);
	}
	
}
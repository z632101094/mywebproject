package com.example.springboot.mywebproject.dao;

import org.springframework.stereotype.Repository;

import com.example.springboot.mywebproject.entity.User;
import com.example.springboot.mywebproject.request.UserRequest;

@Repository(value = "userDao")
public interface UserDao extends BaseDao<User>{
    User selectByUsername(UserRequest userRequest);
}

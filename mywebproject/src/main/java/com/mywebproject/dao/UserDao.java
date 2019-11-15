package com.mywebproject.dao;

import org.springframework.stereotype.Repository;

import com.mywebproject.entity.User;
import com.mywebproject.request.UserRequest;

@Repository(value = "userDao")
public interface UserDao extends BaseDao<User>{
    User selectByUsername(UserRequest userRequest);
}

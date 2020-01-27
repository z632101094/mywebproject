package com.example.springboot.mywebproject.dao.impl;

import org.springframework.stereotype.Repository;

import com.example.springboot.mywebproject.dao.UserDao;
import com.example.springboot.mywebproject.entity.User;
import com.example.springboot.mywebproject.request.UserRequest;

@Repository(value = "userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

    @Override
    public User selectByUsername(UserRequest userRequest) {
        return sqlSessionTemplate.selectOne("tbl_user.selectByUsername",userRequest);
    }
}

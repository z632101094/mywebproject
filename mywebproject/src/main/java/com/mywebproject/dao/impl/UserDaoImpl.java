package com.mywebproject.dao.impl;

import org.springframework.stereotype.Repository;

import com.mywebproject.dao.UserDao;
import com.mywebproject.entity.User;
import com.mywebproject.request.UserRequest;

@Repository(value = "userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

    @Override
    public User selectByUserName(UserRequest userRequest) {
        return sqlSessionTemplate.selectOne("tbl_user.selectByUserName",userRequest);
    }
}

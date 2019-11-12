package com.mywebproject.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mywebproject.entity.User;

@Service
public interface UserService extends BaseService<User>{
	User selectByUserName(String userName);
}

package com.mywebproject.mapper;
 
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.mywebproject.entity.User;
 
@Mapper
public interface UserMapper{
 
    @Insert("INSERT INTO `myweb`.`user_` (`username`, `password`) VALUES (#{userName}, #{password})")
    void insert(User user);
    
    @Select("SELECT * FROM user_ WHERE username = #{userName}")
    @Results({
        @Result(property = "userName",  column = "username"),
        @Result(property = "password", column = "password")
    })
    User getByUserName(String userName);
}
package com.example.springboot.mapper;
 
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.springboot.entity.User;
 
@Mapper
public interface UserMapper {
 
    @Insert("INSERT INTO `myweb`.`user_` (`username`, `password`) VALUES (#{userName}, #{password})")
    void insert(User insert);
    
}
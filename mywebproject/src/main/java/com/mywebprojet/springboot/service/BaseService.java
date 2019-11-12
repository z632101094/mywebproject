package com.mywebprojet.springboot.service;
import java.util.List;

public interface BaseService<T>{

    public T get(Integer id);

    public List<T> selectListByEntity(T entity);
    
    public Integer save(T entity);

    public void update(T entity);

    public void updateByPrimaryKeySelective(T entity);

    public void delete(Integer id);

    public void delete(String[] ids);

}
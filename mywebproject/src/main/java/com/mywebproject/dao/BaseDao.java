package com.mywebproject.dao;

import java.util.List;

public interface BaseDao<T>
{

    public T get(Integer id);

    public List<T> selectListByEntity(T entity);
    
    public Integer save(T entity);

    public void update(T entity);

    public void updateByPrimaryKeySelective(T entity);

    public void delete(Integer id);

    public void delete(String[] ids);
    
}

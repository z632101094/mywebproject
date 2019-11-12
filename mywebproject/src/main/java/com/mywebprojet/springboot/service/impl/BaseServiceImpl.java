package com.mywebprojet.springboot.service.impl;

import java.util.List;

import com.mywebprojet.springboot.service.BaseService;

public class BaseServiceImpl<T>implements BaseService<T> {

	@Override
	public T get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> selectListByEntity(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer save(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByPrimaryKeySelective(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String[] ids) {
		// TODO Auto-generated method stub
		
	}

}

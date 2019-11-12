package com.mywebproject.service.impl;

import java.util.List;

import com.mywebproject.dao.BaseDao;
import com.mywebproject.service.BaseService;

public class BaseServiceImpl<T>implements BaseService<T> {

    private BaseDao<T> baseDao;

    public BaseDao<T> getBaseDao() {
        return baseDao;
    }
    public void setBaseDao(BaseDao<T> baseDao) {
        this.baseDao = baseDao;
    }
	@Override
	public T get(Integer id) {
		return baseDao.get(id);
	}
	@Override
	public Integer save(T entity) {
		return baseDao.save(entity);
	}
	@Override
	public void update(T entity) {
		baseDao.update(entity);
	}

	@Override
	public void updateByPrimaryKeySelective(T entity) {
		baseDao.updateByPrimaryKeySelective(entity);
	}
	@Override
	public void delete(Integer id) {
		baseDao.delete(id);
	}
	@Override
	public void delete(String[] ids) {
		baseDao.delete(ids);
	}
	@Override
	public List<T> selectListByEntity(T entity) {
		return baseDao.selectListByEntity(entity);
	}
}

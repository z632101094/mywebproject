package com.example.springboot.mywebproject.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.springboot.mywebproject.dao.BaseDao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@Repository
public class BaseDaoImpl<T>  implements BaseDao<T> {
	private Class<T> entityClass;
	private String className="";
    
    @Autowired
    @Qualifier("sqlSessionTemplate")
    protected transient SqlSessionTemplate sqlSessionTemplate;

    @SuppressWarnings({ "unchecked", "rawtypes" })
   	public BaseDaoImpl() {
           this.entityClass = null;
           Class c = getClass();
           Type type = c.getGenericSuperclass();
           if (type instanceof ParameterizedType) {
               Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
               this.entityClass = (Class<T>) parameterizedType[0];
               String name=entityClass.getName();
               this.className=name.substring(name.lastIndexOf(".")+1);
           }
       }
	@Override
	public T get(Integer id) {
		return sqlSessionTemplate.selectOne("tbl_"+this.className.toLowerCase()+".selectByPrimaryKey", id);
	}
	@Override
	public Integer save(T entity) {
		return sqlSessionTemplate.insert("tbl_"+this.className.toLowerCase()+".insertSelective",entity);
	}
	@Override
	public void updateByPrimaryKeySelective(T entity) {
		sqlSessionTemplate.update("tbl_"+this.className.toLowerCase()+".updateByPrimaryKeySelective",entity);
	}

	@Override
	public void update(T entity) {
		sqlSessionTemplate.update("tbl_"+this.className.toLowerCase()+".updateByPrimaryKey",entity);
	}
	@Override
	public void delete(Integer id) {
		sqlSessionTemplate.delete("tbl_"+this.className.toLowerCase()+".deleteByPrimaryKey", id);
	}
	@Override
	public void delete(String[] ids) {
		for(String id:ids){
			sqlSessionTemplate.delete("tbl_"+this.className.toLowerCase()+".deleteByPrimaryKey", id);
		}
	}
	@Override
	public List<T> selectListByEntity(T entity) {
		return sqlSessionTemplate.selectList("tbl_"+this.className.toLowerCase()+".selectListByEntity", entity);
	}
}

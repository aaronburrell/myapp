package com.test.app.dao.impl;

import java.util.List;

import com.test.app.dao.HibernateDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.app.dao.TestDAO;
import com.test.app.entity.TestEntity;

@SuppressWarnings("rawtypes")
@Transactional
@Repository
public class TestDAOImpl extends HibernateDao implements TestDAO {

	@SuppressWarnings("unchecked")
	public TestDAOImpl() {
		setClazz(TestEntity.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void insert(TestEntity testEntity) {
		create(testEntity);

	}

	@SuppressWarnings("unchecked")
	@Override
	public void remove(TestEntity testEntity) {
		delete(testEntity);

	}


   @SuppressWarnings("unchecked")
public List<TestEntity> getAllRows(){
	  return (List<TestEntity>) currentSession.createQuery("SELECT t FROM TestEntity t").list();
   }



}

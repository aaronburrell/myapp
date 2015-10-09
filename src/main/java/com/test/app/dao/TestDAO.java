package com.test.app.dao;

import java.util.List;

import com.test.app.entity.TestEntity;

public interface TestDAO {

	
	public void insert(TestEntity testEntity);
	
	public void remove(TestEntity testEntity);
	
	public List<TestEntity> getAllRows();
	
	
}

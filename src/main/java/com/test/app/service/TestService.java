package com.test.app.service;

import java.util.List;

import com.test.app.document.TestDocument;
import com.test.app.entity.TestEntity;

public interface TestService {
	
	public String insert(TestEntity entity);
	public String remove(TestEntity entity);
	public String insert(TestDocument doc);
	public String remove(TestDocument doc);
	public List<TestEntity> getAll();
	public List<TestDocument> getAllDocuments();

}

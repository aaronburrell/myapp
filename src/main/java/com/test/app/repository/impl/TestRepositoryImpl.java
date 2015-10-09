package com.test.app.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.app.document.TestDocument;
import com.test.app.repository.TestRepository;
import com.test.app.repository.config.MongoRepository;

@Repository
@SuppressWarnings("rawtypes")
public class TestRepositoryImpl extends MongoRepository implements TestRepository{
	
	@SuppressWarnings("unchecked")
	public TestRepositoryImpl(){
		setClazz(TestDocument.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void add(TestDocument doc) {
		create(doc);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void remove(TestDocument doc) {
		delete(doc);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TestDocument> getAllDocs() {
		
		return list();
	}

}

package com.test.app.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.app.dao.TestDAO;
import com.test.app.document.TestDocument;
import com.test.app.entity.TestEntity;
import com.test.app.repository.TestRepository;
import com.test.app.service.TestService;

@Transactional
@Service
public class TestServiceImpl implements TestService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	TestDAO testDao;
	
	@Autowired
	TestRepository testRes;

	@Override
	public String insert(TestEntity entity) {
		logger.info("We are about to add a new record");
		testDao.insert(entity);
		logger.info("We finished adding a new record");
		return "We added a new record!";
	}

	@Override
	public String remove(TestEntity entity) {
		logger.info("We are about to delete a new record");
		testDao.remove(entity);
		logger.info("We finished deleting a new record");
		return "We deleted a record!";
	}
	
	@Override
	public List<TestEntity> getAll(){
		logger.info("We are about to get all the table values");
		List<TestEntity> values = testDao.getAllRows();
		logger.info("We got all the table values and the size is: " + values.size());
		return values;
	}

	@Override
	public String insert(TestDocument doc) {
		logger.info("We are about to insert a document");
		testRes.add(doc);
		logger.info("We finished inserting a document");
		return "We added a record!";
	}

	@Override
	public String remove(TestDocument doc) {
		logger.info("We are about to remove a document");
		testRes.remove(doc);
		logger.info("We removed a document");
		return "We removed a record!";
	}

	@Override
	public List<TestDocument> getAllDocuments() {
		logger.info("We are about to get all the document values");
		List<TestDocument> values = testRes.getAllDocs();
		logger.info("We got all the document values and the size is: " + values.size());
		return values;
	}

}

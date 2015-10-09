package com.test.app.repository;

import java.util.List;

import com.test.app.document.TestDocument;

public interface TestRepository {
	
	public void add (TestDocument doc);
	public void remove(TestDocument doc);
	public List<TestDocument> getAllDocs();

}

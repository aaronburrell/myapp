package com.test.app.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.slf4j.Logger;

import com.test.app.document.TestDocument;
import com.test.app.entity.TestEntity;
import com.test.app.service.TestService;

@Controller
public class TestController {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	TestService testService;


	@RequestMapping(value="/", method = RequestMethod.GET)
	public String testGooglePlusAuthMethod() {
		logger.info("Made it to Test Controller  testGooglePlusAuthMethod() Method...");
		logger.info("We are about to look for all the records");
		TestEntity entity = new TestEntity();
		entity.setNumberVal(new Integer("40"));
		entity.setStringVal("This is a test string two!");
		String returnVal = "";
	    returnVal = testService.insert(entity);
	    logger.info("This is the retrun value: " + returnVal);
		List<TestEntity> values = testService.getAll();
		logger.info("This is the total size of the table: " +values.size());

		//TestDocument doc = new TestDocument();
		//doc.setId("526c1566300457439599ae13");
		//doc.setStringVal("a");
		//doc.setNumberVal(11);
		//String returnVal = "";
		//returnVal = testService.remove(doc);
		//logger.info("This is the retrun value: " + returnVal);
		//List<TestDocument> values = testService.getAllDocuments();
		//logger.info("This is the total size of the documents: " +values.size());
		return "index";
	}

	@RequestMapping(value="/driveapitest", method = RequestMethod.GET)
	public String testDriveApiMethod() {
		logger.info("Made it to Test Controller testDriveApiMethod()  Method...");
		return "quickstart";
	}

	@RequestMapping(value="/showMessage", method = RequestMethod.GET)
	public String showMessageMethod() {
		logger.info("This is the showmessage request");
		return "showMessage";
	}

}

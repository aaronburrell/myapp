package com.test.app.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection ="test")
public class TestDocument {
	
	@Id
	private String Id;
	
	private String stringVal;
	
	private Integer numberVal;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getStringVal() {
		return stringVal;
	}

	public void setStringVal(String stringVal) {
		this.stringVal = stringVal;
	}

	public Integer getNumberVal() {
		return numberVal;
	}

	public void setNumberVal(Integer numberVal) {
		this.numberVal = numberVal;
	}
	
	
	
}

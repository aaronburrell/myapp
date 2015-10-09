package com.test.app.repository.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

@Configuration
public class MongoRepository<T> {
	
	private Class<T> clazz = null;
	
	public void setClazz(final Class<T> clazzToSet) {
	    this.clazz = clazzToSet;
	    }
	
	public @Bean
	MongoDbFactory mongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(new MongoClient(), "test");
	}
	
	public @Bean
	MongoTemplate mongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
		return mongoTemplate;
	}
	
	public void create (T clazz){
		try {
			mongoTemplate().insert(clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete (T clazz){
		try {
			mongoTemplate().remove(clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<T> list(){
		List<T> retVal = null;
		try {
		retVal = mongoTemplate().findAll((Class<T>) clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
}

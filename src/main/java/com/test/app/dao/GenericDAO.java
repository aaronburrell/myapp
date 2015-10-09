package com.test.app.dao;


public interface GenericDAO<T,K> {
	
	public void create (T entity);
	
	public T read (K key);
	
	public void update (T entity);
	
	public void delete (T entity);
	

}

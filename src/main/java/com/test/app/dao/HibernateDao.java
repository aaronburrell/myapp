package com.test.app.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class HibernateDao<T, K> implements GenericDAO<T, K> {
	
private Class<T> clazz = null;

@Autowired
protected SessionFactory sessionFactory;
protected Session currentSession;
	
	public void setClazz(final Class<T> clazzToSet) {
	    this.clazz = clazzToSet;
	    }
	
	public void openSession(){
		currentSession = sessionFactory.openSession();
	}
	
	public void getCurrentSession(){currentSession = sessionFactory.getCurrentSession();}

	@Override
	public void create(T entity) {
		getCurrentSession();
		currentSession.persist(entity);
		currentSession.flush();

		
	}

	@SuppressWarnings("unchecked")
	@Override
	public T read(K key) {
		getCurrentSession();
		T t = (T) currentSession.get(this.clazz, (Serializable) key);
		currentSession.flush();

		return t;
	}

	@Override
	public void update(T entity) {
		getCurrentSession();
		currentSession.merge(entity);
		currentSession.flush();

		
	}

	@Override
	public void delete(T entity) {
		getCurrentSession();
		currentSession.delete(entity);
		currentSession.flush();

		
	}
	
	public void saveOrUpdate(T entity){
		getCurrentSession();
		currentSession.saveOrUpdate(entity);
		currentSession.flush();

	}
	
	

}

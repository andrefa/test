package org.fiveware.model.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.fiveware.model.dao.BaseDao;
import org.fiveware.model.entity.BaseEntity;
import org.fiveware.model.util.HibernateUtil;
import org.hibernate.Session;

public class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T> {

	private Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		this.entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> list() {
		return getSession().createCriteria(this.entityClass).list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public T findById(Long pk) {
		return (T) getSession().get(entityClass, pk);
	}
	
	@Override
	public void save(T entity) {
		entity.setId((Long) getSession().save(entity));
	}

	@Override
	public void update(T entity) {
		getSession().update(entity);
	}

	@Override
	public void delete(T t) {
		getSession().delete(t);
	}
	
	protected Class<T> getEntityClass() {
		return entityClass;
	}

	protected Session getSession() {
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}
	
}
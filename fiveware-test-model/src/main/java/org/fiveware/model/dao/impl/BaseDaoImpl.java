package org.fiveware.model.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.fiveware.model.dao.BaseDao;
import org.fiveware.model.entity.BaseEntity;
import org.fiveware.model.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;

public class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T> {

	private Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		this.entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	@SuppressWarnings("unchecked")
	public T findById(Long id) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		try {
			return (T) session.get(getEntityClass(), id);
		} finally {
			transaction.commit();
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> list() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			Criteria criteria = session.createCriteria(getEntityClass());
			criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
			return criteria.list();
		} finally {
			transaction.commit();
		}
	}

	@Override
	public void save(T object) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();

		try {
			session.save(object);
			session.flush();
		} catch (HibernateException e) {
			transaction.rollback();
		} finally {
			transaction.commit();
		}
	}

	@Override
	public void update(T object) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();

		try {
			session.update(object);
			session.flush();
		} catch (HibernateException e) {
			transaction.rollback();
		} finally {
			transaction.commit();
		}
	}

	@Override
	public void delete(T object) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();

		try {
			session.delete(object);
			session.flush();
			session.clear();
		} catch (HibernateException e) {
			transaction.rollback();
		} finally {
			transaction.commit();

		}
	}

	protected Class<T> getEntityClass() {
		return entityClass;
	}

	protected Session getSession() {
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}

}
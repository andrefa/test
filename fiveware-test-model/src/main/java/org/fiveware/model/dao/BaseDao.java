package org.fiveware.model.dao;

import java.util.List;

import org.fiveware.model.entity.BaseEntity;

public interface BaseDao <T extends BaseEntity> {

	List<T> list();

	T findById(Long pk);

	void save(T t);

	void update(T t);

	void delete(T t);

}
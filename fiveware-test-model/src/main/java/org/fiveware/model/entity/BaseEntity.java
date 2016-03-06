package org.fiveware.model.entity;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@SuppressWarnings("serial")
public abstract class BaseEntity implements Serializable {

	public abstract Long getId();

	public abstract void setId(Long id);

}
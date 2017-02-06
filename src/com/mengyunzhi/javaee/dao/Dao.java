/*
 * $Id$
 */
package com.mengyunzhi.javaee.dao;

import com.mengyunzhi.javaee.entity.IdEntity;

import java.io.Serializable;
import java.util.Collection;

/**
 * Dao. Interface.
 */

public interface Dao {

	Class<?> getFeaturedClass();

	IdEntity get(Serializable id);

	Serializable create(IdEntity object);

	IdEntity update(IdEntity object);

	int delete(Serializable id);

	int delete(IdEntity object);
	Collection<?> paginate(int page, int pageSize);
	Collection<?> all();
}

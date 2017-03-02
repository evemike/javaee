package com.mengyunzhi.javaee.dao;

import com.mengyunzhi.javaee.entity.Klass;

/**
 * 班级
 */
public class KlassDao extends AbstractDao {

	private static final long serialVersionUID = 1L;

	/**
	 * 传入实体类
	 */
	@Override
	public Class<Klass> getFeaturedClass() {
		return Klass.class;
	}

}

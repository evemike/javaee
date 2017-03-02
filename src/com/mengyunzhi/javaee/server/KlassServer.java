package com.mengyunzhi.javaee.server;

import com.mengyunzhi.javaee.dao.KlassDao;
import com.mengyunzhi.javaee.entity.Klass;


public class KlassServer {
	/**
	 * 保存
	 */
	public static void saveKlass(Long teacherId, String name) {
	    Klass klass = new Klass(name, teacherId);
	    KlassDao klassDao = new KlassDao();
	    klassDao.create(klass);
	    return;
	}

}

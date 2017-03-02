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
	
	/**
	 * 获取klass实体
	 * @param teacherId 关键字
	 * @return Klass
	 */
	public static Klass getKlassById(Long teacherId) {
	    KlassDao klassDao = new KlassDao();
	    Klass klass = (Klass) klassDao.get(teacherId);
	    return klass;
	}

}

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
	public static Klass getKlassById(Long id) {
	    KlassDao klassDao = new KlassDao();
	    Klass klass = (Klass) klassDao.get(id);
	    return klass;
	}
	
	/**
	 * 更新klass
	 * @param id
	 * @param name
	 * @param teacherId
	 */
	public static void updateKlassByIdNameTeacherId(Long id, String name, Long teacherId) {
	    KlassDao klassDao = new KlassDao();
	    Klass klass = (Klass)klassDao.get(id);
	    klass.setName(name);
	    klass.setTeacherId(teacherId);
	    klassDao.update(klass);
	    return;
	}
	
	/**
	 * 删除
	 * @param id
	 */
	public static void deleteKlassById(Long id) {
	    KlassDao klassDao = new KlassDao();
	    klassDao.delete(id);
	    return;
	}

}

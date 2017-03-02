package com.mengyunzhi.javaee.daoTest;

import org.junit.Test;

import com.mengyunzhi.javaee.dao.KlassDao;
import com.mengyunzhi.javaee.entity.Klass;

public class KlassTest {
    @Test
    public void create() {
        // 存数
        Klass klass = new Klass("一四班", 1);
        KlassDao klassDao = new KlassDao();
        Long klassId = (Long) klassDao.create(klass);
        System.out.println("存入的ID为:" + klassId);
        
        // 取数
        Klass saveKlass = (Klass) klassDao.get(klassId);
        System.out.println(saveKlass);
    }

}

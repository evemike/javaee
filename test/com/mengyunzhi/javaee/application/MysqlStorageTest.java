package com.mengyunzhi.javaee.application;

import org.junit.Test;

import com.mengyunzhi.javaee.entity.Teacher;
import com.mengyunzhi.javaee.exception.CreateException;

public class MysqlStorageTest {
    @Test
    public void deleteTest () throws CreateException {
        MysqlStorage mysqlStorage = new MysqlStorage();
        Long id = 123L;
        mysqlStorage.delete(Teacher.class, id);
    }
       
    @Test
    public void getTest() {
        MysqlStorage mysqlStorage = new MysqlStorage();
        Long id = 3L;
        Teacher teacher = (Teacher) mysqlStorage.get(Teacher.class, id);
        System.out.println(teacher);
    }
}

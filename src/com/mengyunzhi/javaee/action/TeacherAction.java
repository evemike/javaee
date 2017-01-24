package com.mengyunzhi.javaee.action;

import java.util.Collection;

import com.mengyunzhi.javaee.application.MysqlStorage;
import com.mengyunzhi.javaee.dao.Dao;
import com.mengyunzhi.javaee.dao.TeacherDao;
import com.mengyunzhi.javaee.entity.IdEntity;
import com.mengyunzhi.javaee.entity.Teacher;
import com.opensymphony.xwork2.Preparable;

public class TeacherAction extends AbstractCRUDAction implements Preparable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Dao teacherDao;
    private Collection<IdEntity> teachers;
    @SuppressWarnings("unchecked")
    public String index() {
        System.out.println("index");
        teachers = teacherDao.findAll();
        System.out.println(teachers);
        return "success";
    }

    @Override
    public void prepare() throws Exception {
        teacherDao = new TeacherDao();
        teacherDao.setStorage(new MysqlStorage());
        System.out.println("prepare");
    }

    @Override
    protected Dao getDao() {
        return teacherDao;
    }

    public Collection<IdEntity> getTeachers() {
        return teachers;
    }
}

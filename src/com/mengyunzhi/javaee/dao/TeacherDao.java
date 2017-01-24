package com.mengyunzhi.javaee.dao;

import com.mengyunzhi.javaee.entity.Teacher;

public class TeacherDao extends AbstractDao {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public Class getFeaturedClass() {
        return Teacher.class;
    }

}

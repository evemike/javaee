package com.mengyunzhi.javaee.action;

import java.util.ArrayList;
import java.util.List;

import com.mengyunzhi.javaee.dao.TeacherDao;
import com.mengyunzhi.javaee.entity.Teacher;

public class TeacherAction extends Action{
    private static final long serialVersionUID = 1L;
    // 定义教师列表
    private List<Teacher> teachers = new ArrayList<Teacher>();
    public List<Teacher> getTeachers() {
        return teachers;
    }
    
    @SuppressWarnings("unchecked")
    public String all() {
        // 获取所有数据
        TeacherDao teacherDao = new TeacherDao();
        this.teachers = (List<Teacher>) teacherDao.all();
        return SUCCESS;
    }

}

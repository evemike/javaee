package com.mengyunzhi.javaee.server;

import com.mengyunzhi.javaee.entity.Teacher;

public class TeacherServer {
    public static Boolean update(Teacher newTeacher) {
        // 获取数据表数据
        Teacher teacher = Teacher.getTeacherById(newTeacher.getId());
        
        // 赋值
        teacher.setEmail(newTeacher.getEmail());
        teacher.setName(newTeacher.getName());
        teacher.setUsername(newTeacher.getUsername());
        teacher.setPassword(newTeacher.getPassword());
        teacher.setSex(newTeacher.getSex());
        
        // 更新并返回
        teacher.update();
        return true;
    }
    
    public static Boolean deleteById(int id) {
        Teacher teacher = Teacher.getTeacherById(id);
        return teacher.delete();
    }
}

package com.mengyunzhi.javaee.action.teacher;

import com.mengyunzhi.javaee.entity.Teacher;;

public class Edit {
   
    private int id; // 关健字
    private Teacher teacher; // 教师实体
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    // teacher会被V层读取，但并可能由V层传入，所以，只需要get函数.
    public Teacher getTeacher() {
        return teacher;
    }

    // 该execute方法将被自动调用， 方法的返回类型必须为String
    public String execute() {
        // 获取要编辑的教师
        teacher = Teacher.getTeacherById(id);
        System.out.println(teacher.toString());
        return "success";
    }
}

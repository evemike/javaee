package com.mengyunzhi.javaee.action.teacher;

import com.mengyunzhi.javaee.action.Action;
import com.mengyunzhi.javaee.entity.Teacher;
import com.mengyunzhi.javaee.server.TeacherServer;

public abstract class TeacherAction extends Action{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    protected TeacherServer teacherServer = new TeacherServer();
    protected Long id; // 关健字
    protected Teacher teacher; // 教师实体
    protected String username;
    protected String password;
    protected String sex;
    protected String name;
    protected String email;
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // teacher会被V层读取，但并可能由V层传入，所以，只需要get函数.
    public Teacher getTeacher() {
        return teacher;
    }
}

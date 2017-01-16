package com.mengyunzhi.javaee.action.teacher;

import com.mengyunzhi.javaee.entity.Teacher;
import com.mengyunzhi.javaee.server.TeacherServer;

public class Update {
    private int id;
    private String name;
    private String username;
    private Boolean sex;
    private String password;
    private String email;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(String sex) {
        if (sex.equals("0")) {
            this.sex = false; 
        } else {
            this.sex = true;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // 该execute方法将被自动调用， 方法的返回类型必须为String
    public String execute() {
        // 获取要编辑的教师，并实例化
        Teacher teacher = new Teacher(id, name, username, email, sex, password);
       
        // 更新
        TeacherServer.update(teacher);

        return "success";
    }
}

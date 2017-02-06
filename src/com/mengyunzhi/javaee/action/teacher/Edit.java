package com.mengyunzhi.javaee.action.teacher;

import com.mengyunzhi.javaee.server.TeacherServer;

public class Edit extends TeacherAction{
      
    public String getName() {
        return teacher.getName();
    }
    
    public String getUsername() {
        return teacher.getUsername();
    }
    
    public String getSex() {
        return TeacherServer.getStringSexFromBoolean(teacher.getSex());
    }
    
    public String getEmail() {
        return teacher.getEmail();
    }
    
    public String getPassword() {
        return teacher.getPassword();
    }
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    // 该execute方法将被自动调用， 方法的返回类型必须为String
    public String execute() {       
        // 获取要编辑的教师
        teacher = TeacherServer.getTeacherById(id);
        return "success";
    }
    
    
}

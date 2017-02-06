package com.mengyunzhi.javaee.action.teacher;

import com.mengyunzhi.javaee.exception.UpdateException;
import com.mengyunzhi.javaee.server.TeacherServer;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;



public class Update extends TeacherAction{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @RequiredStringValidator(message = "姓名不能为空")
    @StringLengthFieldValidator(minLength = "2", trim = true, message = "姓名不能少于2位")
    public void setName(String name) {
        this.name = name;
    }

    // 该execute方法将被自动调用， 方法的返回类型必须为String
    public String execute() {
        try {
            TeacherServer.update(id, name, sex, email, password);
        } catch (UpdateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            addActionError(e.getMessage());
        }
        
        return SUCCESS;
    }
}

package com.mengyunzhi.javaee.action.teacher;

import com.mengyunzhi.javaee.exception.CreateException;
import com.mengyunzhi.javaee.server.TeacherServer;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;

public class Save extends TeacherAction {
    /**
     * 创建时间：2017.1.16
     */
    private static final long serialVersionUID = 1L;

    @RequiredStringValidator(message = "用户名不能为空")
    @StringLengthFieldValidator(minLength = "4", maxLength = "8", trim = true, message = "用户名必须介于4-8之间")
    public void setUsername(String username) {
        this.username = username;
    }

    @RequiredStringValidator(message = "姓名不能为空")
    @StringLengthFieldValidator(minLength = "2", trim = true, message = "姓名不能少于2位")
    public void setName(String name) {
        this.name = name;
    }

    // 该execute方法将被自动调用， 方法的返回类型必须为String
    public String execute() {
        try {
            TeacherServer.create(name, username, sex, email, password);
        } catch (CreateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            addActionError(e.getMessage());
        }
        return SUCCESS;
    }
    
}

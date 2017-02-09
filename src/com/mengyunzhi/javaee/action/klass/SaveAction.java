package com.mengyunzhi.javaee.action.klass;

import com.mengyunzhi.javaee.action.Action;
import com.mengyunzhi.javaee.entity.Teacher;
import com.mengyunzhi.javaee.server.TeacherServer;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;

public class SaveAction extends Action {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private Teacher teacher;
    private Long teacherId;

    public String getName() {
        return name;
    }

    @RequiredStringValidator(message = "名称不能为空")
    @StringLengthFieldValidator(minLength = "2", maxLength = "8", trim = true, message = "名称必须介于2-8之间")
    public void setName(String name) {
        this.name = name;
    }

    public void setTeacherId(Long teacherId) {
        if(teacherId == 200) {
            this.addFieldError("teacherId", "传入的teacherId无效");
        }
        this.teacherId = teacherId;
        // 获取教师实体
        this.setTeacher(TeacherServer.getTeacherById(this.teacherId));
    }

    public String execute() {
        return SUCCESS;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}

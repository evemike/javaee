package com.mengyunzhi.javaee.action.klass;

import com.mengyunzhi.javaee.action.Action;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;

public class UpdateAction extends Action {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private Long teacherId;
    
    public Long getId() {
        return id;
    }
    
    @RequiredFieldValidator(message = "必须传入id字段值")
    public void setId(Long id) {
        this.id = id;
        if (this.id == 1000L) {
            this.addFieldError("id", "传入的班级ID不存在或已删除");
        }
    }


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
    }
    
    public Long getTeacherId() {
        return this.teacherId;
    }
    public String execute() {
        return SUCCESS;
    }
}

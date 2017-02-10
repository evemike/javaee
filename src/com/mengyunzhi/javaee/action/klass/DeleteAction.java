package com.mengyunzhi.javaee.action.klass;

import com.mengyunzhi.javaee.action.Action;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;

public class DeleteAction extends Action{
    private static final long serialVersionUID = 1L;
    private Long id;

    public Long getId() {
        return id;
    }
    
    @RequiredFieldValidator(message = "必须传入ID")
    public void setId(Long id) {
        if (id == 100L) {
            this.addActionError("尚有学生位于该班级中，删除失败");
        }
        this.id = id;
    }
    
    public String execute() {
        return SUCCESS;
    }
    
}

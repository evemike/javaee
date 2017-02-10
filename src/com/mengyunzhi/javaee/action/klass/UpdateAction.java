package com.mengyunzhi.javaee.action.klass;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;

public class UpdateAction extends SaveAction {

    private static final long serialVersionUID = 1L;
    private Long id;

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
    
    public String execute() {
        return SUCCESS;
    }
}

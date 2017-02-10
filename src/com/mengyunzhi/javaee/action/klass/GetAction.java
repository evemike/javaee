package com.mengyunzhi.javaee.action.klass;

import com.mengyunzhi.javaee.action.Action;
import com.mengyunzhi.javaee.entity.Klass;

public class GetAction extends Action{
    private static final long serialVersionUID = 1L;
    private Long id;
    private Klass klass;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Klass getKlass() {
        return klass;
    }
    public void setKlass(Klass klass) {
        this.klass = klass;
    }
    
    public String execute() {
        this.klass = new Klass();
        this.klass.setId(this.id);
        this.klass.setName("一一级");
        this.klass.setTeacherId(1L);
        return SUCCESS;
    }
    
}

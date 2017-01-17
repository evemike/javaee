package com.mengyunzhi.javaee.action.teacher;

import com.mengyunzhi.javaee.server.TeacherServer;
import com.opensymphony.xwork2.ActionSupport;

public class Delete extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // 该execute方法将被自动调用， 方法的返回类型必须为String
    public String execute() {
        TeacherServer.deleteById(id);
        return "success";
    }
}

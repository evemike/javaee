package com.mengyunzhi.javaee.action.teacher;

import com.mengyunzhi.javaee.server.TeacherServer;


public class DeleteAction extends TeacherAction {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    // 该execute方法将被自动调用， 方法的返回类型必须为String
    public String execute() {
        try {
            TeacherServer.deleteById(id);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            addActionError(e.getMessage());
        }
        return SUCCESS;
    }
}

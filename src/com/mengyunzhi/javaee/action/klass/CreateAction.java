package com.mengyunzhi.javaee.action.klass;

import com.mengyunzhi.javaee.action.Action;
import com.mengyunzhi.javaee.server.KlassServer;

public class CreateAction extends Action {

    private static final long serialVersionUID = 1L;

    private String name;

	private long teacherId;

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public String execute() {
        KlassServer.saveKlass(this.teacherId, this.name);
		return SUCCESS;
	}

}

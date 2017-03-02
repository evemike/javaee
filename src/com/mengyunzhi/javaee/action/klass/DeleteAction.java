package com.mengyunzhi.javaee.action.klass;

import com.mengyunzhi.javaee.action.Action;
import com.mengyunzhi.javaee.server.KlassServer;

public class DeleteAction extends Action {

    private static final long serialVersionUID = 1L;
    private long id;

	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String execute() {
		KlassServer.deleteKlassById(id);
		return SUCCESS;
	}

}

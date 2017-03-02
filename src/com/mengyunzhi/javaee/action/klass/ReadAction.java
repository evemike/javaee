package com.mengyunzhi.javaee.action.klass;

import com.mengyunzhi.javaee.action.Action;
import com.mengyunzhi.javaee.entity.Klass;
import com.mengyunzhi.javaee.server.KlassServer;

public class ReadAction extends Action {

    private static final long serialVersionUID = 1L;

    private Klass klass;

	private long klassId;

	public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }

    public long getKlassId() {
        return klassId;
    }

    public void setKlassId(long klassId) {
        this.klassId = klassId;
    }

    public String execute() {
        klass = KlassServer.getKlassById(klassId);
		return SUCCESS;
	}

}

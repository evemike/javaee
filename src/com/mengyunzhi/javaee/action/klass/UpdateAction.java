package com.mengyunzhi.javaee.action.klass;

import com.mengyunzhi.javaee.action.Action;
import com.mengyunzhi.javaee.server.KlassServer;

public class UpdateAction extends Action {

    private static final long serialVersionUID = 1L;

    private Long klassId;

	private String name;

	private Long teacherId;

	public Long getKlassId() {
        return klassId;
    }

    public void setKlassId(Long klassId) {
        this.klassId = klassId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String execute() {
        KlassServer.updateKlassByIdNameTeacherId(klassId, name, teacherId);
		return SUCCESS;
	}

}

package com.mengyunzhi.javaee.serverTest;

import org.junit.Test;

import com.mengyunzhi.javaee.server.KlassServer;

public class KlassServerTest {
    @Test
	public void saveKlass() {
        KlassServer.saveKlass(4L, "二三班");
	}

}

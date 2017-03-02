package com.mengyunzhi.javaee.serverTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mengyunzhi.javaee.entity.Klass;
import com.mengyunzhi.javaee.server.KlassServer;

public class KlassServerTest {
    @Test
	public void saveKlass() {
        KlassServer.saveKlass(4L, "二三班");
	}
    
    @Test
    public void getKlassByIdTest() {
        Klass klass = KlassServer.getKlassById(1L);
        System.out.println(klass);
    }
    
    @Test
    public void updateKlassByIdNameTeacherIdTest () {
        Long id = 1L;
        String name = "更新班级";
        Long teacherId = 10L;   // 注意，该值必须存在于Teacher表中。
        KlassServer.updateKlassByIdNameTeacherId(id, name, teacherId);
        
        // 获取这个班级信息
        Klass klass = KlassServer.getKlassById(id);
        assertEquals(klass.getId(), id);        // 判断
        assertEquals(klass.getName(), name);    // 判断
    }
    
    @Test
    public void deleteKlassByIdTest() {
        KlassServer.deleteKlassById(4L);
    }

}

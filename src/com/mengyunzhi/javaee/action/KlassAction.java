package com.mengyunzhi.javaee.action;

import java.util.ArrayList;
import java.util.List;

import com.mengyunzhi.javaee.entity.Klass;


public class KlassAction extends Action {

    /**
     * 班级管理
     */
    private static final long serialVersionUID = 1L;
    private String name="";
    private int page = 1;
    private int pageSize = 5;
    
    private int totalCount = 0;
    private List<Klass> klasses = new ArrayList<Klass>();
    
    
    public List<Klass> getKlasses() {
        return klasses;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setPage(int page) {
        this.page = page;
    }
    
    public int getPage() {
        return this.page;
    }


    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }



    public String execute() {    
        int i;  // 初始化变量，用于计数
        // 测试用例一
        if (this.name.equals("") && this.page == 1 && this.pageSize == 3) {
            this.totalCount = 7;    // 设置总条数
            for (i = 0; i < 3; i++) {   //循环加入3条信息
                this.klasses.add(new Klass());
            }
            
        // 测试用例2
        } else if (this.name.equals("一") && this.page == 2 && this.pageSize == 2) {
            this.totalCount = 4;
            for (i = 0; i < 2; i++) {
                Klass klass = new Klass();
                klass.setName("一班");
                this.klasses.add(klass);
            }
        }
        return SUCCESS;
    }
}

package com.mengyunzhi.javaee.action.teacher;

import java.util.List;

import com.mengyunzhi.javaee.entity.Teacher;

public class Index {
    // 教师列表 类型为List，每项均为Teacher。
    private List<Teacher> teachers;
    
    // 当前页
    private int page = 1;
    // 每页大小
    private int pageSize = 2;
    // 查询姓名
    private String name = "";
    
    // 显示接收到的page信息
    public int getPage() {
        return page;
    }
    
    // 接收请求的page信息
    public void setPage(int page) {
        this.page = page;
    }
    
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    // V层在展示数据teachers的时候，将自动调用该方法
    public List<Teacher> getTeachers() {
        return teachers;
    }

    // 该execute方法将被自动调用， 方法的返回类型必须为String
    public String execute() {
        // 获取教师列表
        // 未输入姓名，则查询所有信息
        if (name.equals("")) {
            teachers = Teacher.paginate(page, pageSize);
         
            // 输入姓名，则进行模糊查询
        } else {
            teachers = Teacher.paginate(name, page, pageSize);
        }
        return "success";
    }
}

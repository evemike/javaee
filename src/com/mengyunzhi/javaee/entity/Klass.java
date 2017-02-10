package com.mengyunzhi.javaee.entity;

public class Klass {
    private Long id = 1L;
    private String name = "一一班";
    private Long teacherId;
    private Teacher teacher = new Teacher(1L, "张三", "zhangsan", "zhangsan@yunzhiclub.com", true, "123456");
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    
    @Override
    public String toString() {
        return "Klass [id=" + id + ", name=" + name + ", teacher=" + teacher
                + "]";
    }
    public Long getTeacherId() {
        return teacherId;
    }
    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    } 
}

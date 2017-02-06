package com.mengyunzhi.javaee.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Index;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;

// 声明主体
@Entity
@Table(name = "Teacher")
public class Teacher implements IdEntity {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    // 声明主键
    // 声明一个名为idGenerator的native类型构造器
    // 使用这个构造器设置ID为自增属性
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "native")
    @GeneratedValue(generator = "idGenerator")
    private Long teacherId; // 主键

    private String name; // 姓名

    // 声明长度(用户名不超过20位长度，定长能够提升效率）
    @Column(columnDefinition = "char(20)")
    // 声明为索引（该字段将来用于查询 ，增加索引将大幅提升查询效率）
    @Index(name = "username")
    private String username; // 用户名
    private String email; // 邮箱
    private Boolean sex = false; // 性别 0：男；1：女
    // 密码采用sha1 md5加密，长度固定。
    @Column(columnDefinition = "char(40)")
    private String password; // 密码

    @Override
    public Serializable getId() {
        return getTeacherId();
    }

    @Override
    public void setId(Serializable id) {
        setTeacherId((Long) id);
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    @RequiredStringValidator(message = "姓名不能为空")
    @StringLengthFieldValidator(minLength = "2", trim = true, message = "姓名不能少于2位")
    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

   public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Teacher() {

    }

    public Teacher(long teacherId, String name, String username, String email,
            Boolean sex, String password) {
        this.teacherId = teacherId;
        this.name = name;
        this.username = username;
        this.email = email;
        this.sex = sex;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Teacher [teacherId=" + teacherId + ", name=" + name
                + ", username=" + username + ", email=" + email + ", sex="
                + sex + ", password=" + password + "]";
    }
}

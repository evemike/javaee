package com.mengyunzhi.javaee.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
    // 继承ActionSupport后，必须生明serialVersionUID，该值为于对类及对象进行序列化与反序列化
    private static final long serialVersionUID = 1L;
    private String username = "";   // 用户名
    private String password = "";   // 密码
    private int code = 200;         // 状态码.200正常
    private boolean isPassed = false; // 用户名密码是否正确
    
    public int getCode() {
        return code;
    }


    public boolean getIsPassed() {
        return this.isPassed;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 登陆，当用户名等于zhangsan ，密码为：123456时。返回用户名密码通过验证
     * @return
     */
    public String login() {
        if (this.username.equals("zhangsan") && this.password.equals("123456")) {
            this.isPassed = true;
        }
        return SUCCESS;
    }
}

package com.mengyunzhi.javaee.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public abstract class Action extends ActionSupport implements ServletResponseAware{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    protected int code = 200; // 状态码.200正常
    
    // 响应信息
    protected HttpServletResponse response;

    @Override
    public void setServletResponse(HttpServletResponse response) {
        // 设置发送文件头:允许跨域的地址
        response.setHeader("Access-Control-Allow-Origin", "*");
        // 允许前端带cookie访问（cookie跨域）
        response.setHeader("Access-Control-Allow-Credentials", "true");
        // 设置请允许的请求方法
        response.setHeader("Access-Control-Allow-Methods", "GET,HEAD,OPTIONS,POST,PUT");
        // 设置服务器允许的头类型
        response.setHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
        // 告诉浏览器我已经记得你了，一天之内不要再发送OPTIONS请求了
        response.setHeader("Access-Control-Max-Age", Integer.toString(3600 * 24));
        this.response = response;
    }

    public int getCode() {
        return this.code;
    }
    
}

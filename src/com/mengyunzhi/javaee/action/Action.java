package com.mengyunzhi.javaee.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public abstract class Action extends ActionSupport implements ServletResponseAware, Preparable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void prepare() throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        // 设置发送文件头:允许跨域的地址
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET,HEAD,OPTIONS,POST,PUT");
        response.setHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
    }

}

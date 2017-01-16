package com.mengyunzhi.javaee.action.teacher;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class Save {
    private String username;
    private String password;
    private String sex;
    private String name;
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // 该execute方法将被自动调用， 方法的返回类型必须为String
    public String execute() {
        // 实例化并加载数据库配置文件
        Configuration configuration = new Configuration().configure();
        // 构造服务注册对象
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .buildServiceRegistry();
        // 创建会话工厂（session factory））
        SessionFactory sessionFactory = configuration
                .buildSessionFactory(serviceRegistry);
        // 创建会话（这里的session也是会话的意思，我们以前接触的http中的session，处理的是用户与服务器的对话）
        Session session = sessionFactory.getCurrentSession();
        // 开启事务（使用缓冲池进行数据库的连接）
        Transaction transaction = session.beginTransaction();

        // 在这里，必须使用try catch finally语句。来确定会话正常关闭.
        // 否则，当操作数据库产生错误时，你可能需要重启mysql服务
        try {
            // 初例化 赋值
            com.mengyunzhi.javaee.entity.Teacher teacher = new com.mengyunzhi.javaee.entity.Teacher();
            teacher.setName(name);
            teacher.setUsername(username);
            teacher.setEmail(email);
            teacher.setPassword(password);
            
            // 由于sex的类型是String对象，所以需要使用equals()来判等
            if (sex.equals("0")) {
                teacher.setSex(false);
            } else {
                teacher.setSex(true);
            }
            
            session.save(teacher);

            // 提交事务
            transaction.commit();
            
        // 捕获异常
        } catch (HibernateException e) {

        } finally {
            // 如果session处于开启状态，则关闭session
            if (session.isOpen()) {
                // 关闭会话
                session.close();
            }
        }

        return "success"; // 返回字符串success
    }
}

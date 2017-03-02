package com.mengyunzhi.javaee.entityTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

public class TableTest {
    @Test
    public void createTable() {

        // 实例化并加载数据库配置文件
        Configuration configuration = new Configuration().configure();
        // 构造服务注册对象
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().
                applySettings(configuration.getProperties()).
                buildServiceRegistry();
        // 创建会话工厂（session factory））
        SessionFactory sessionFactory = configuration
                .buildSessionFactory(serviceRegistry);
        // 创建会话（这里的session也是会话的意思，我们以前接触的http中的session，处理的是用户与服务器的对话）
        Session session = sessionFactory.getCurrentSession();
        // 开启事务（使用缓冲池进行数据库的连接）
        session.beginTransaction();
        // 关闭session
        session.close();
    }
}

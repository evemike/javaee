package com.mengyunzhi.javaee.common.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Mysql类型的Javaee数据库
 * @author panjie
 *
 */
public class MysqlJavaee {
    static private SessionFactory sessionFactory;
    static public Session getCurrentSession() {
        // 每个数据库只需要一个sessionFactory，在这里进行单一实例处理。
        if (null == sessionFactory) {
            // 实例化并加载数据库配置文件
            Configuration configuration = new Configuration().configure();
            
            // 构造服务注册对象
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().
                    applySettings(configuration.getProperties()).
                    buildServiceRegistry();
            // 创建会话工厂（session factory））
            sessionFactory = configuration
                    .buildSessionFactory(serviceRegistry);
        }
        
        // 创建会话（这里的session也是会话的意思，我们以前接触的http中的session，处理的是用户与服务器的对话）
        return sessionFactory.getCurrentSession();
    }
}

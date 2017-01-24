package com.mengyunzhi.javaee.application;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Table;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;
import org.hibernate.cfg.Configuration;
import org.hibernate.metamodel.source.annotations.entity.EntityClass;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.mengyunzhi.javaee.entity.IdEntity;
import com.mengyunzhi.javaee.entity.Teacher;
import com.mengyunzhi.javaee.exception.CreateException;
import com.mengyunzhi.javaee.exception.StorageException;
import com.mengyunzhi.javaee.exception.UpdateException;

public class MysqlStorage implements Storage {

    /**
     * 
     */
    private static final long serialVersionUID = 6722564663111368306L;
    static private SessionFactory sessionFactory;

    static public Session getCurrentSession() {
        // 每个数据库只需要一个sessionFactory，在这里进行单一实例处理。
        if (null == sessionFactory) {
            // 实例化并加载数据库配置文件
            Configuration configuration = new Configuration().configure();

            // 构造服务注册对象
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .buildServiceRegistry();
            // 创建会话工厂（session factory））
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }

        // 创建会话（这里的session也是会话的意思，我们以前接触的http中的session，处理的是用户与服务器的对话）
        return sessionFactory.getCurrentSession();
    }

    @Override
    public IdEntity get(Class entityClass, Serializable id) {
        IdEntity object = null;
        // 创建会话（这里的session也是会话的意思，我们以前接触的http中的session，处理的是用户与服务器的对话）
        Session session = getCurrentSession();
        // 开启事务（使用缓冲池进行数据库的连接）
        Transaction transaction = session.beginTransaction();

        // 在这里，必须使用try catch finally语句。来确定会话正常关闭.
        // 否则，当操作数据库产生错误时，你可能需要重启mysql服务
        try {
            // 使用Teacher.class来获取到Teacher的类名(包括包名)
            object = (IdEntity) session.get(entityClass, id);

            // 提交事务
            transaction.commit();

            // 捕获异常
        } catch (HibernateException e) {
            // 如果事务执行异常，则回滚事务
            if (null != transaction) {
                transaction.rollback();
            }

            // 打印异常
            e.printStackTrace();
        } finally {
            // 如果session处于开启状态，则关闭session
            if (session.isOpen()) {
                // 关闭会话
                session.close();
            }
        }

        return object;
    }

    @Override
    public Serializable create(IdEntity object) throws CreateException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IdEntity update(IdEntity object) throws UpdateException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Serializable merge(IdEntity object) throws StorageException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int delete(Class entityClass, Serializable id)
            throws CreateException {
        // 创建会话（这里的session也是会话的意思，我们以前接触的http中的session，处理的是用户与服务器的对话）
        Session session = getCurrentSession();
        // 开启事务（使用缓冲池进行数据库的连接）
        Transaction transaction = session.beginTransaction();
        // 在这里，必须使用try catch finally语句。来确定会话正常关闭.
        // 否则，当操作数据库产生错误时，你可能需要重启mysql服务
        try {
            IdEntity object = (IdEntity) session.get(entityClass, id);
            // 删除
            session.delete(object);

            // 提交事务
            transaction.commit();
            // 捕获异常
        } catch (HibernateException e) {
            // 如果事务执行异常，则回滚事务
            if (null != transaction) {
                try {
                    transaction.rollback();
                } catch (TransactionException te) {
                    // 抛出异常
                    te.printStackTrace();
                }
            }

            // 抛出异常
            e.printStackTrace();
        } finally {
            // 如果session处于开启状态，则关闭session
            if (session.isOpen()) {
                // 关闭会话
                session.close();
            }
        }

        return 0;
    }

    @Override
    public int delete(IdEntity object) throws CreateException {
        // 创建会话（这里的session也是会话的意思，我们以前接触的http中的session，处理的是用户与服务器的对话）
        Session session = getCurrentSession();
        // 开启事务（使用缓冲池进行数据库的连接）
        Transaction transaction = session.beginTransaction();

        // 在这里，必须使用try catch finally语句。来确定会话正常关闭.
        // 否则，当操作数据库产生错误时，你可能需要重启mysql服务
        try {
            // 删除
            session.delete(object);

            // 提交事务
            transaction.commit();

            // 捕获异常
        } catch (HibernateException e) {
            // 如果事务执行异常，则回滚事务
            if (null != transaction) {
                try {
                    transaction.rollback();
                } catch (TransactionException te) {
                    // 抛出异常
                    throw (te);
                }
            }

            // 抛出异常
            throw (e);
        } finally {
            // 如果session处于开启状态，则关闭session
            if (session.isOpen()) {
                // 关闭会话
                session.close();
            }
        }

        return 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Collection<IdEntity> findAll(Class entityClass) {

        // 创建会话（这里的session也是会话的意思，我们以前接触的http中的session，处理的是用户与服务器的对话）
        Session session = getCurrentSession();
        // 开启事务（使用缓冲池进行数据库的连接）
        Transaction transaction = session.beginTransaction();
        Collection<IdEntity> entities = new ArrayList<IdEntity>();
        // 在这里，必须使用try catch finally语句。来确定会话正常关闭.
        // 否则，当操作数据库产生错误时，你可能需要重启mysql服务
        try {
            // 查询Teacher表,注意：是Teacher ，而不是 teacher
            Query query = session.createQuery("from "
                    + entityClass.getSimpleName());
            // 预查询，只有在事务提交时，才进行查询操作
            entities = query.list();
            // 提交事务
            transaction.commit();

            // 捕获异常
        } catch (HibernateException e) {
            // 如果事务执行异常，则回滚事务
            if (null != transaction) {
                try {
                    transaction.rollback();
                } catch (TransactionException te) {
                    te.printStackTrace();
                }

            }

            // 打印异常
            e.printStackTrace();
        } finally {
            // 如果session处于开启状态，则关闭session
            if (session.isOpen()) {
                // 关闭会话
                session.close();
            }
        }

        return entities;
    }

    @Override
    public Collection paginate(Class featuredClass, String query, int page,
            int pageSize) {
        // TODO Auto-generated method stub
        return null;
    }

}

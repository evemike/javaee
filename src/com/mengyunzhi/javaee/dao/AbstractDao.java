/*
 * $Id$
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.mengyunzhi.javaee.dao;

import com.mengyunzhi.javaee.entity.IdEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * AbstractDao.
 */

public abstract class AbstractDao implements Serializable, Dao {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static SessionFactory sessionFactory;
    
    protected static Session getCurrentSession() {
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
    
    public IdEntity get(Serializable id) {
        IdEntity object = null;
        // 创建会话（这里的session也是会话的意思，我们以前接触的http中的session，处理的是用户与服务器的对话）
        Session session = getCurrentSession();
        // 开启事务（使用缓冲池进行数据库的连接）
        Transaction transaction = session.beginTransaction();

        // 在这里，必须使用try catch finally语句。来确定会话正常关闭.
        // 否则，当操作数据库产生错误时，你可能需要重启mysql服务
        try {
            // 使用Teacher.class来获取到Teacher的类名(包括包名)
            object = (IdEntity) session.get(getFeaturedClass(), id);

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

    public Serializable create(IdEntity object) {
        // 创建会话（这里的session也是会话的意思，我们以前接触的http中的session，处理的是用户与服务器的对话）
        Session session = getCurrentSession();
        // 开启事务（使用缓冲池进行数据库的连接）
        Transaction transaction = session.beginTransaction();
        // 在这里，必须使用try catch finally语句。来确定会话正常关闭.
        // 否则，当操作数据库产生错误时，你可能需要重启mysql服务
        try {

            // 新增数据
            session.save(object);

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

        return object.getId();
    }

    public IdEntity update(IdEntity object) {
     // 创建会话（这里的session也是会话的意思，我们以前接触的http中的session，处理的是用户与服务器的对话）
        Session session = getCurrentSession();
        // 开启事务（使用缓冲池进行数据库的连接）
        Transaction transaction = session.beginTransaction();

        // 在这里，必须使用try catch finally语句。来确定会话正常关闭.
        // 否则，当操作数据库产生错误时，你可能需要重启mysql服务
        try {
            // 删除
            session.update(object);

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

        return object;
    }
    
    public int delete(Serializable id) {
        IdEntity idEntity = this.get(id);
        return this.delete(idEntity);
    }

    public int delete(IdEntity object) {
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
    public Collection<?> all() {
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
                    + getFeaturedClass().getSimpleName());
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

    @SuppressWarnings("unchecked")
    public Collection<?> paginate(int page, int pageSize) {
     // 创建会话（这里的session也是会话的意思，我们以前接触的http中的session，处理的是用户与服务器的对话）
        Session session = getCurrentSession();
        // 开启事务（使用缓冲池进行数据库的连接）
        Transaction transaction = session.beginTransaction();
        Collection<IdEntity> entities = new ArrayList<IdEntity>();
        // 在这里，必须使用try catch finally语句。来确定会话正常关闭.
        // 否则，当操作数据库产生错误时，你可能需要重启mysql服务
        try {
            // 查询Teacher表,注意：是Teacher ，而不是 teacher
            String hql = "from " + getFeaturedClass().getSimpleName();
            // 预查询，只有在事务提交时，才进行查询操作
            entities = (ArrayList<IdEntity>) session.createQuery(hql)
                    .setFirstResult(page)
                    .setMaxResults(pageSize)
                    .list();
            
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
}

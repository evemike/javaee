package com.mengyunzhi.javaee.entityTest;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.mengyunzhi.javaee.dao.AbstractDao;
import com.mengyunzhi.javaee.entity.Klass;


public class KlassTest {
    @Test
    public void create() {
        // 获取Session
        Session session = AbstractDao.getCurrentSession();
    
        // 开启事务（使用缓冲池进行数据库的连接）
        Transaction transaction = session.beginTransaction();

        try {
            // 实例化实体
            Klass klass = new Klass("一一班", 17);
            session.save(klass);

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

    }
}

package com.mengyunzhi.javaee.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Index;

import com.mengyunzhi.javaee.common.db.MysqlJavaee;

// 声明主体
@Entity
public class Teacher {
    // 声明主键
    // 声明一个名为idGenerator的native类型构造器
    // 使用这个构造器设置ID为自增属性
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "native")
    @GeneratedValue(generator = "idGenerator")
    private int id; // 主键
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

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

    // 输出性别
    public String getSexAttr() {
        if (sex) {
            return "0男";
        } else {
            return "1女";
        }
    }

    public Teacher() {

    }

    public Teacher(int id, String name, String username, String email,
            Boolean sex, String password) {
        // super();
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.sex = sex;
        this.password = password;
    }

    public String toString() {
        return "Teacher [id=" + id + ", name=" + name + ", username="
                + username + ", email=" + email + ", sex=" + sex
                + ", password=" + password + "]";
    }

    @SuppressWarnings("unchecked")
    static public List<Teacher> all() {
        // 实例化列表 teachers
        List<Teacher> teachers = new ArrayList<Teacher>();

        // 创建会话（这里的session也是会话的意思，我们以前接触的http中的session，处理的是用户与服务器的对话）
        Session session = MysqlJavaee.getCurrentSession();
        // 开启事务（使用缓冲池进行数据库的连接）
        Transaction transaction = session.beginTransaction();

        // 在这里，必须使用try catch finally语句。来确定会话正常关闭.
        // 否则，当操作数据库产生错误时，你可能需要重启mysql服务
        try {
            // 查询Teacher表,注意：是Teacher ，而不是 teacher
            Query query = session.createQuery("from Teacher");
            // 预查询，只有在事务提交时，才进行查询操作
            teachers = query.list();
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

        return teachers;
    }

    /**
     * 分页数据
     * 
     * @param page
     *            第几页
     * @param pageSize
     *            每页大小
     * @return
     */
    @SuppressWarnings("unchecked")
    static public List<Teacher> paginate(int page, int pageSize) {
        // 实例化列表 teachers
        List<Teacher> teachers = new ArrayList<Teacher>();
        // 创建会话（这里的session也是会话的意思，我们以前接触的http中的session，处理的是用户与服务器的对话）
        Session session = MysqlJavaee.getCurrentSession();
        // 开启事务（使用缓冲池进行数据库的连接）
        Transaction transaction = session.beginTransaction();

        // 在这里，必须使用try catch finally语句。来确定会话正常关闭.
        // 否则，当操作数据库产生错误时，你可能需要重启mysql服务
        try {
            // 查询Teacher表,注意：是Teacher ，而不是 teacher
            Query query = session.createQuery("from Teacher");
            // 计算并设置第一条记录的位置
            int index = (page - 1) * pageSize;
            query.setFirstResult(index);

            // 每页大小
            query.setMaxResults(pageSize);
            teachers = query.list();
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

        return teachers;
    }

    /**
     * 分页数据
     * 
     * @param page
     *            第几页
     * @param pageSize
     *            每页大小
     * @return
     */
    @SuppressWarnings("unchecked")
    static public List<Teacher> paginate(String name, int page, int pageSize) {
        // 实例化列表 teachers
        List<Teacher> teachers = new ArrayList<Teacher>();
        // 创建会话（这里的session也是会话的意思，我们以前接触的http中的session，处理的是用户与服务器的对话）
        Session session = MysqlJavaee.getCurrentSession();
        // 开启事务（使用缓冲池进行数据库的连接）
        Transaction transaction = session.beginTransaction();

        // 在这里，必须使用try catch finally语句。来确定会话正常关闭.
        // 否则，当操作数据库产生错误时，你可能需要重启mysql服务
        try {
            // 查询Teacher表,注意：是Teacher ，而不是 teacher
            Query query = session.createQuery("from Teacher where name like '%"
                    + name + "%'");
            // 计算并设置第一条记录的位置
            int index = (page - 1) * pageSize;
            query.setFirstResult(index);

            // 每页大小
            query.setMaxResults(pageSize);
            teachers = query.list();
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

        return teachers;
    }

    /**
     * 通过ID获取Teacher实体
     * 
     * @param id
     * @return
     */
    static public Teacher getTeacherById(int id) {
        // 实例化Teacher
        Teacher teacher = new Teacher();
        // 创建会话（这里的session也是会话的意思，我们以前接触的http中的session，处理的是用户与服务器的对话）
        Session session = MysqlJavaee.getCurrentSession();
        // 开启事务（使用缓冲池进行数据库的连接）
        Transaction transaction = session.beginTransaction();

        // 在这里，必须使用try catch finally语句。来确定会话正常关闭.
        // 否则，当操作数据库产生错误时，你可能需要重启mysql服务
        try {
            // 使用Teacher.class来获取到Teacher的类名(包括包名)
            teacher = (Teacher) session.get(Teacher.class, id);

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

        return teacher;
    }

    public Boolean update() {
        // 创建会话（这里的session也是会话的意思，我们以前接触的http中的session，处理的是用户与服务器的对话）
        Session session = MysqlJavaee.getCurrentSession();
        // 开启事务（使用缓冲池进行数据库的连接）
        Transaction transaction = session.beginTransaction();

        // 在这里，必须使用try catch finally语句。来确定会话正常关闭.
        // 否则，当操作数据库产生错误时，你可能需要重启mysql服务
        try {
            // 更新
            session.update(this);
            
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

        return true;
    }
    
    
    public Boolean delete() {
     // 创建会话（这里的session也是会话的意思，我们以前接触的http中的session，处理的是用户与服务器的对话）
        Session session = MysqlJavaee.getCurrentSession();
        // 开启事务（使用缓冲池进行数据库的连接）
        Transaction transaction = session.beginTransaction();

        // 在这里，必须使用try catch finally语句。来确定会话正常关闭.
        // 否则，当操作数据库产生错误时，你可能需要重启mysql服务
        try {
            // 删除
            session.delete(this);
            
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

        return true;
    }
    
    
}

package com.mengyunzhi.javaee.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Index;


// 声明主体
@Entity
@Table(name="Teacher")
public class Teacher implements IdEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    // 声明主键
    // 声明一个名为idGenerator的native类型构造器
    // 使用这个构造器设置ID为自增属性
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "native")
    @GeneratedValue(generator = "idGenerator")
    private Long teacherId; // 主键
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
    
    @Override
    public Serializable getId() {
        return getTeacherId();
    }
    
    @Override
    public void setId(Serializable id) {
        setTeacherId((Long) id); 
    }
    
    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
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


    public Teacher() {

    }

    public Teacher(long teacherId, String name, String username, String email,
            Boolean sex, String password) {
        this.teacherId = teacherId;
        this.name = name;
        this.username = username;
        this.email = email;
        this.sex = sex;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Teacher [teacherId=" + teacherId + ", name=" + name
                + ", username=" + username + ", email=" + email + ", sex="
                + sex + ", password=" + password + "]";
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
//    @SuppressWarnings("unchecked")
//    static public List<Teacher> paginate(int page, int pageSize) {
//        // 实例化列表 teachers
//        List<Teacher> teachers = new ArrayList<Teacher>();
//        // 创建会话（这里的session也是会话的意思，我们以前接触的http中的session，处理的是用户与服务器的对话）
//        Session session = MysqlJavaee.getCurrentSession();
//        // 开启事务（使用缓冲池进行数据库的连接）
//        Transaction transaction = session.beginTransaction();
//
//        // 在这里，必须使用try catch finally语句。来确定会话正常关闭.
//        // 否则，当操作数据库产生错误时，你可能需要重启mysql服务
//        try {
//            // 查询Teacher表,注意：是Teacher ，而不是 teacher
//            Query query = session.createQuery("from Teacher");
//            // 计算并设置第一条记录的位置
//            int index = (page - 1) * pageSize;
//            query.setFirstResult(index);
//
//            // 每页大小
//            query.setMaxResults(pageSize);
//            teachers = query.list();
//            // 提交事务
//            transaction.commit();
//
//            // 捕获异常
//        } catch (HibernateException e) {
//            // 如果事务执行异常，则回滚事务
//            if (null != transaction) {
//                transaction.rollback();
//            }
//
//            // 打印异常
//            e.printStackTrace();
//        } finally {
//            // 如果session处于开启状态，则关闭session
//            if (session.isOpen()) {
//                // 关闭会话
//                session.close();
//            }
//        }
//
//        return teachers;
//    }

    /**
     * 分页数据
     * 
     * @param page
     *            第几页
     * @param pageSize
     *            每页大小
     * @return
     */
//    @SuppressWarnings("unchecked")
//    static public List<Teacher> paginate(String name, int page, int pageSize) {
//        // 实例化列表 teachers
//        List<Teacher> teachers = new ArrayList<Teacher>();
//        // 创建会话（这里的session也是会话的意思，我们以前接触的http中的session，处理的是用户与服务器的对话）
//        Session session = MysqlJavaee.getCurrentSession();
//        // 开启事务（使用缓冲池进行数据库的连接）
//        Transaction transaction = session.beginTransaction();
//
//        // 在这里，必须使用try catch finally语句。来确定会话正常关闭.
//        // 否则，当操作数据库产生错误时，你可能需要重启mysql服务
//        try {
//            // 查询Teacher表,注意：是Teacher ，而不是 teacher
//            Query query = session.createQuery("from Teacher where name like '%"
//                    + name + "%'");
//            // 计算并设置第一条记录的位置
//            int index = (page - 1) * pageSize;
//            query.setFirstResult(index);
//
//            // 每页大小
//            query.setMaxResults(pageSize);
//            teachers = query.list();
//            // 提交事务
//            transaction.commit();
//
//            // 捕获异常
//        } catch (HibernateException e) {
//            // 如果事务执行异常，则回滚事务
//            if (null != transaction) {
//                transaction.rollback();
//            }
//
//            // 打印异常
//            e.printStackTrace();
//        } finally {
//            // 如果session处于开启状态，则关闭session
//            if (session.isOpen()) {
//                // 关闭会话
//                session.close();
//            }
//        }
//
//        return teachers;
//    }

//    /**
//     * 通过ID获取Teacher实体
//     * 
//     * @param id
//     * @return
//     */


//    public Boolean update() {
//        // 创建会话（这里的session也是会话的意思，我们以前接触的http中的session，处理的是用户与服务器的对话）
//        Session session = MysqlJavaee.getCurrentSession();
//        // 开启事务（使用缓冲池进行数据库的连接）
//        Transaction transaction = session.beginTransaction();
//
//        // 在这里，必须使用try catch finally语句。来确定会话正常关闭.
//        // 否则，当操作数据库产生错误时，你可能需要重启mysql服务
//        try {
//            // 更新
//            session.update(this);
//            
//            // 提交事务
//            transaction.commit();
//
//            // 捕获异常
//        } catch (HibernateException e) {
//            // 如果事务执行异常，则回滚事务
//            if (null != transaction) {
//                transaction.rollback();
//            }
//
//            // 打印异常
//            e.printStackTrace();
//        } finally {
//            // 如果session处于开启状态，则关闭session
//            if (session.isOpen()) {
//                // 关闭会话
//                session.close();
//            }
//        }
//
//        return true;
//    }
 

}

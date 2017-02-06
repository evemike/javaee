package com.mengyunzhi.javaee.server;

import java.io.Serializable;
import java.util.List;

import com.mengyunzhi.javaee.dao.TeacherDao;
import com.mengyunzhi.javaee.entity.Teacher;
import com.mengyunzhi.javaee.exception.CreateException;
import com.mengyunzhi.javaee.exception.UpdateException;

public class TeacherServer {
    static private TeacherDao teacherDao = null;
    /**
     * 获取TeacherDao，单例模式
     * @return
     */
    static TeacherDao getCurrentTeacherDao() {
        if (null == teacherDao) {
            teacherDao = new TeacherDao();
        }
        return teacherDao;
    }
    /**
     * 获取教师实体   
     * @param teacherId
     * @return
     */
    static public Teacher getTeacherById(Long teacherId) {
        TeacherDao teacherDao = getCurrentTeacherDao();
        Teacher teacher = (Teacher) teacherDao.get(teacherId);
        return teacher;
    }
    
    /**
     * 新增用数据 
     * @param name 姓名
     * @param username 用户名
     * @param sex 性别
     * @param email 邮箱地址
     * @param password 密码
     * @return
     * @throws CreateException
     */
    static public Serializable create(String name, String username, String sex, String email, String password) throws CreateException {
        // 实例化教师实体，并赋值
        Teacher teacher = new Teacher();
        teacher = setTeacherAttr(teacher, name, username, sex, email, password);
        
        // 获取teacherDao，并执行创建工作
        TeacherDao teacherDao = getCurrentTeacherDao();
        return teacherDao.create(teacher);
    }
    
    /**
     * 将String类型的sex转化为boolean类型
     * @param sex
     * @return
     */
    static public boolean getBooleanSexFromString(String sex) {
        if (sex.equals("0")) {
            return true;
        } else {
            return false;
        }
    }
    
    static public String getStringSexFromBoolean(Boolean sex) {
        if (sex.equals(true)) {
            return "1";
        } else {
            return "0";
        }
    }
    
    /**
     * 更新
     * @param teacherId ID
     * @param name 姓名
     * @param username 用户名
     * @param sex 性别
     * @param email 邮箱
     * @param password 密码
     * @return
     * @throws UpdateException
     */
    static public Teacher update(Long teacherId, String name, String sex, String email, String password) throws UpdateException {
        // 实例化教师实体，并赋值
        Teacher teacher = getTeacherById(teacherId); 
        teacher = setTeacherAttr(teacher, name, teacher.getUsername(), sex, email, password);
        
        TeacherDao teacherDao = getCurrentTeacherDao();
        return (Teacher) teacherDao.update(teacher);
    }
    
    /**
     * 设置教师属性
     * @param teacher 教师实体
     * @param name 姓名
     * @param username 用户名
     * @param sex 性别
     * @param email 邮箱
     * @param password 密码
     * @return
     */
    public static Teacher setTeacherAttr(Teacher teacher, String name, String username, String sex, String email, String password ) {
        teacher.setEmail(email);
        teacher.setName(name);
        teacher.setPassword(password);
        teacher.setSex(getBooleanSexFromString(sex));
        teacher.setUsername(username);
        return teacher;
    }
    
    /**
     * 通过ID删除教师
     * @param id
     * @return
     * @throws CreateException
     */
    public static int deleteById(Long id) throws CreateException {
        Teacher teacher = getTeacherById(id);
        TeacherDao teacherDao = getCurrentTeacherDao();
        return teacherDao.delete(teacher);
    }
    
    /**
     * 分页查询
     * @param name 姓名
     * @param page 第几页
     * @param pageSize 每页多少条
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Teacher> paginate(String name, int page, int pageSize) {
        TeacherDao teacherDao = getCurrentTeacherDao();
        return (List<Teacher>) teacherDao.paginate(page, pageSize);
    }
}

package com.xgon.classmanager.mapper;

import com.xgon.classmanager.common.Page;
import com.xgon.classmanager.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * <p>FileName:&ensp;com.xgon.classmanager.mapper.<strong>StudentMapper.java</strong></p>
 * <p>Date:&ensp;2021-09-24 13:55</p>
 * <p>Description:&ensp;与数据库进行交互，持久化数据，为学生信息操作（增删改查）服务提供支持</p>
 * <a href="https://www.cnblogs.com/mingyue1818/p/3714162.html">MyBatis传入多个参数的问题</a>
 *
 * @author <a href="mail to: laoshi1998@outlook.com" rel="nofollow">xgon</a>
 * @version 1.0.0
 */
@Mapper
public interface StudentMapper {

    /**
     * <p>MethodName:&ensp;<strong>addStudent</strong></p>
     * <p>Description:&ensp;学生新增</p>
     *
     * @param student 学生信息
     */
    void addStudent(Student student);

    /**
     * <p>MethodName:&ensp;<strong>editStudent</strong></p>
     * <p>Description:&ensp;学生修改</p>
     *
     * @param student 学生信息
     */
    void editStudent(Student student);

    /**
     * <p>MethodName:&ensp;<strong>removeStudent</strong></p>
     * <p>Description:&ensp;学生查询</p>
     *
     * @param student 学生（部分）信息
     */
    void removeStudent(Student student);

    /**
     * <p>MethodName:&ensp;<strong>queryStudent</strong></p>
     * <p>Description:&ensp;学生查询</p>
     *
     * @param page    查询分页对象
     * @param student 学生（部分）信息
     * @return java.util.List<com.xgon.classmanager.entity.Student> 查询结果集合
     */
    List<Serializable> queryStudent(@Param("page") Page page, @Param("student") Student student);

    /**
     * <p>MethodName:&ensp;<strong>addStudentParent</strong></p>
     * <p>Description:&ensp;学生关联家长</p>
     *
     * @param student 学生（部分）信息
     */
    void addStudentParent(Student student);
}

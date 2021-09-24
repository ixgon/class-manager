package com.xgon.classmanager.service;

import com.xgon.classmanager.api.ResultCode;
import com.xgon.classmanager.common.Page;
import com.xgon.classmanager.entity.Student;

import java.util.Map;

/**
 * <p>FileName:&ensp;com.xgon.classmanager.service.<strong>StudentService.java</strong></p>
 * <p>Date:&ensp;2021-09-24 13:53</p>
 * <p>Description:&ensp;提供每位学生信息的增删改查服务接口</p>
 *
 * @author <a href="mail to: laoshi1998@outlook.com" rel="nofollow">xgon</a>
 * @version 1.0.0
 */
public interface StudentService {

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
}

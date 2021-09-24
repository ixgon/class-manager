package com.xgon.classmanager.service;

import com.xgon.classmanager.entity.Student;

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
}

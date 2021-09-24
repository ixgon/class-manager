package com.xgon.classmanager.mapper;

import com.xgon.classmanager.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>FileName:&ensp;com.xgon.classmanager.mapper.<strong>StudentMapper.java</strong></p>
 * <p>Date:&ensp;2021-09-24 13:55</p>
 * <p>Description:&ensp;与数据库交互数据，持久化数据，为学生信息操作的服务提供支持</p>
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
}

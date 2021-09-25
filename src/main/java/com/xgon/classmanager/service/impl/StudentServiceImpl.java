package com.xgon.classmanager.service.impl;

import com.xgon.classmanager.common.Page;
import com.xgon.classmanager.entity.Student;
import com.xgon.classmanager.mapper.StudentMapper;
import com.xgon.classmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>FileName:&ensp;com.xgon.classmanager.service.impl.<strong>StudentServiceImpl.java</strong></p>
 * <p>Date:&ensp;2021-09-24 13:54</p>
 * <p>Description:&ensp;提供每位学生信息的增删改查服务接口实现</p>
 *
 * @author <a href="mail to: laoshi1998@outlook.com" rel="nofollow">xgon</a>
 * @version 1.0.0
 */
@Service
public class StudentServiceImpl implements StudentService {
    private StudentMapper studentMapper;

    @Autowired
    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public void addStudent(Student student) {
        // 转换时间格式 Timestamp.valueOf(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))
        // 在数据库端直接设置  create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
        /// String nowStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        /// student.setCreateTime(nowStr);
        /// student.setUpdateTime(nowStr);

        studentMapper.addStudent(student);
    }

    @Override
    public void editStudent(Student student) {
        /// String nowStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        /// student.setUpdateTime(nowStr);

        studentMapper.editStudent(student);
    }

    @Override
    public void removeStudent(Student student) {
        studentMapper.removeStudent(student);
    }

    @Override
    public void queryStudent(Page page, Student student) {
        page.setRecords(studentMapper.queryStudent(page, student));
    }

    @Override
    public void addStudentParent(Student student) {
        studentMapper.addStudentParent(student);
    }
}

package com.xgon.classmanager.entity;

/**
 * <p>FileName:&ensp;com.xgon.classmanager.entity.<strong>StuClass.java</strong></p>
 * <p>Date:&ensp;2021-09-24 8:45</p>
 * <p>Description:&ensp;学生-班级表</p>
 *
 * @author <a href="mail to: laoshi1998@outlook.com" rel="nofollow">xgon</a>
 * @version 1.0.0
 */
public class StuClass {
    private Integer id;
    private Integer studentId;
    private Integer classroomId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Integer classroomId) {
        this.classroomId = classroomId;
    }
}

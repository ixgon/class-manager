package com.xgon.classmanager.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

/**
 * <p>FileName:&ensp;com.xgon.classmanager.entity.<strong>Student.java</strong></p>
 * <p>Date:&ensp;2021-09-23 17:30</p>
 * <p>Description:&ensp;学生表</p>
 *
 * @author <a href="mail to: laoshi1998@outlook.com" rel="nofollow">xgon</a>
 * @version 1.0.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Student extends Person implements Serializable {
    private String idCard;
    private Classroom classroom;
    private List<Parent> parents;

    public Student() {
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", idCard='" + idCard + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", isDeleted=" + isDeleted +
                ", classroom=" + classroom +
                ", parents=" + parents +
                '}';
    }
}

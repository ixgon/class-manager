package com.xgon.classmanager.service.impl;

import com.xgon.classmanager.common.Page;
import com.xgon.classmanager.entity.Classroom;
import com.xgon.classmanager.mapper.ClassroomMapper;
import com.xgon.classmanager.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>FileName:&ensp;com.xgon.classmanager.service.impl.<strong>ClassroomServiceImpl.java</strong></p>
 * <p>Date:&ensp;2021/9/25 21:44</p>
 * <p>Description:&ensp;提供每个班级信息的增删改查服务接口实现</p>
 *
 * @author <a href="mail to: laoshi1998@outlook.com" rel="nofollow">xgon</a>
 * @version 1.0.0
 */
@Service
public class ClassroomServiceImpl implements ClassroomService {
    private ClassroomMapper classroomMapper;

    @Autowired
    public void setClassroomMapper(ClassroomMapper classroomMapper) {
        this.classroomMapper = classroomMapper;
    }

    @Override
    public void addClassroom(Classroom classroom) {
        classroomMapper.addClassroom(classroom);
    }

    @Override
    public void editClassroom(Classroom classroom) {
        classroomMapper.editClassroom(classroom);
    }

    @Override
    public void removeClassroom(Classroom classroom) {
        classroomMapper.removeClassroom(classroom);
    }

    @Override
    public void queryClassroom(Page page, Classroom classroom) {
        page.setRecords(classroomMapper.queryClassroom(page, classroom));
    }

    @Override
    public void addClassroomStudent(Classroom classroom) {
        classroomMapper.addClassroomStudent(classroom);
    }
}

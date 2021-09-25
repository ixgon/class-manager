package com.xgon.classmanager.service;

import com.xgon.classmanager.common.Page;
import com.xgon.classmanager.entity.Classroom;

/**
 * <p>FileName:&ensp;com.xgon.classmanager.service.<strong>ClassroomService.java</strong></p>
 * <p>Date:&ensp;2021/9/25 21:43</p>
 * <p>Description:&ensp;提供每个班级信息的增删改查服务接口</p>
 *
 * @author <a href="mail to: laoshi1998@outlook.com" rel="nofollow">xgon</a>
 * @version 1.0.0
 */
public interface ClassroomService {

    /**
     * <p>MethodName:&ensp;<strong>addClassroom</strong></p>
     * <p>Description:&ensp;班级新增</p>
     *
     * @param classroom 班级信息
     */
    void addClassroom(Classroom classroom);

    /**
     * <p>MethodName:&ensp;<strong>editClassroom</strong></p>
     * <p>Description:&ensp;班级修改</p>
     *
     * @param classroom 班级信息
     */
    void editClassroom(Classroom classroom);

    /**
     * <p>MethodName:&ensp;<strong>removeClassroom</strong></p>
     * <p>Description:&ensp;班级查询</p>
     *
     * @param classroom 班级（部分）信息
     */
    void removeClassroom(Classroom classroom);

    /**
     * <p>MethodName:&ensp;<strong>queryClassroom</strong></p>
     * <p>Description:&ensp;班级查询</p>
     *
     * @param page      查询分页对象
     * @param classroom 班级（部分）信息
     */
    void queryClassroom(Page page, Classroom classroom);

    /**
     * <p>MethodName:&ensp;<strong>addClassroomStudent</strong></p>
     * <p>Description:&ensp;班级添加学生</p>
     *
     * @param classroom 班级（部分）信息
     */
    void addClassroomStudent(Classroom classroom);
}

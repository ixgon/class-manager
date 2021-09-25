package com.xgon.classmanager.mapper;

import com.xgon.classmanager.common.Page;
import com.xgon.classmanager.entity.Classroom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * <p>FileName:&ensp;com.xgon.classmanager.mapper.<strong>ClassroomMapper.java</strong></p>
 * <p>Date:&ensp;2021/9/25 21:42</p>
 * <p>Description:&ensp;与数据库进行交互，持久化数据，为班级信息操作（增删改查）服务提供支持</p>
 *
 * @author <a href="mail to: laoshi1998@outlook.com" rel="nofollow">xgon</a>
 * @version 1.0.0
 */
@Mapper
public interface ClassroomMapper {

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
     * @return java.util.List<java.io.Serializable> 查询结果集合
     */
    List<Serializable> queryClassroom(@Param("page") Page page, @Param("classroom") Classroom classroom);

    /**
     * <p>MethodName:&ensp;<strong>addClassroomStudent</strong></p>
     * <p>Description:&ensp;班级添加学生</p>
     *
     * @param classroom 班级（部分）信息
     */
    void addClassroomStudent(Classroom classroom);
}

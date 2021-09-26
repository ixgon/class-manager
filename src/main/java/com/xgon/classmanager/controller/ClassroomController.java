package com.xgon.classmanager.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xgon.classmanager.api.ApiResponse;
import com.xgon.classmanager.common.Page;
import com.xgon.classmanager.entity.Classroom;
import com.xgon.classmanager.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>FileName:&ensp;com.xgon.classmanager.controller.<strong>ClassroomController.java</strong></p>
 * <p>Date:&ensp;2021/9/23 23:10</p>
 * <p>Description:&ensp;控制每个班级信息的增删改查</p>
 *
 * @author <a href="mail to: laoshi1998@outlook.com" rel="nofollow">xgon</a>
 * @version 1.0.0
 */
@RestController
@RequestMapping("/classroom")
public class ClassroomController {
    private ClassroomService classroomService;

    @Autowired
    public void setClassroomService(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @PostMapping("/addClassroom")
    public ApiResponse addClassroom(@RequestBody Classroom classroom) {
        classroomService.addClassroom(classroom);
        return ApiResponse.SUCCESS.setData("添加信息成功");
    }

    @PostMapping("/editClassroom")
    public ApiResponse editClassroom(@RequestBody Classroom classroom) {
        classroomService.editClassroom(classroom);
        return ApiResponse.SUCCESS.setData("修改信息成功");
    }

    @PostMapping("/removeClassroom")
    public ApiResponse removeStudent(@RequestBody Classroom classroom) {
        classroomService.removeClassroom(classroom);
        return ApiResponse.SUCCESS.setData("移除信息成功");
    }

    @PostMapping("/page")
    public ApiResponse page(@RequestBody Map<String, Object> models) {
        Page page = new Page();
        page.setPageSize((Integer) models.get("size"));
        page.setCurrentPageNum((Integer) models.get("current"));
        page.buildStartIndex();

        Classroom classroom = new ObjectMapper()
                .convertValue(models.get("data"), new TypeReference<>() {
                });

        classroomService.queryClassroom(page, classroom);

        return ApiResponse.SUCCESS.setData(page);
    }

    @PostMapping("/addClassroomStudent")
    public ApiResponse addClassroomParent(@RequestBody Classroom classroom) {
        classroomService.addClassroomStudent(classroom);
        return ApiResponse.SUCCESS.setData("班级添加学生成功");
    }
}

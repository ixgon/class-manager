package com.xgon.classmanager.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xgon.classmanager.api.ResultCode;
import com.xgon.classmanager.common.Page;
import com.xgon.classmanager.entity.Student;
import com.xgon.classmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>FileName:&ensp;com.xgon.classmanager.controller.<strong>StudentController.java</strong></p>
 * <p>Date:&ensp;2021/9/23 23:08</p>
 * <p>Description:&ensp;控制每位学生信息的增删改查</p>
 *
 * @author <a href="mail to: laoshi1998@outlook.com" rel="nofollow">xgon</a>
 * @version 1.0.0
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResultCode test() {
        System.out.println(1);
        return ResultCode.SUCCESS;
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public ResultCode addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return ResultCode.SUCCESS.setData(1);
    }

    @RequestMapping(value = "/editStudent", method = RequestMethod.POST)
    public ResultCode editStudent(@RequestBody Student student) {
        studentService.editStudent(student);
        return ResultCode.SUCCESS.setData(student);
    }

    @RequestMapping(value = "/removeStudent", method = RequestMethod.POST)
    public ResultCode removeStudent(@RequestBody Student student) {
        studentService.removeStudent(student);
        return ResultCode.SUCCESS.setData(student);
    }

    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public ResultCode page(@RequestBody Map<String, Object> models) {
        Page page = new Page();
        page.setPageSize((Integer) models.get("size"));
        page.setCurrentPageNum((Integer) models.get("current"));
        page.buildStartIndex();

        Student student = new ObjectMapper()
                .convertValue(models.get("data"), new TypeReference<>() {
                });

        System.out.println(studentService.queryStudent(page, student));

        HashMap<String, Object> data = new HashMap<>(3);
        data.put("records", 1);
        data.put("parents", 2);
        data.put("page", page);
        return ResultCode.SUCCESS.setData(data);
    }
}

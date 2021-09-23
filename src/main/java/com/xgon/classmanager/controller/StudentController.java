package com.xgon.classmanager.controller;

import com.xgon.classmanager.api.ResultCode;
import com.xgon.classmanager.entity.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResultCode test() {
        System.out.println(1);
        return ResultCode.SUCCESS;
    }

    public ResultCode addStudent(Student student) {
        return ResultCode.SUCCESS;
    }
}

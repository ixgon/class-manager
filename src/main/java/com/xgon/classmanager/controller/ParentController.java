package com.xgon.classmanager.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xgon.classmanager.api.ApiResponse;
import com.xgon.classmanager.common.Page;
import com.xgon.classmanager.entity.Parent;
import com.xgon.classmanager.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>FileName:&ensp;com.xgon.classmanager.controller.<strong>ParentController.java</strong></p>
 * <p>Date:&ensp;2021/9/23 23:09</p>
 * <p>Description:&ensp;控制每位家长信息的增删改查</p>
 *
 * @author <a href="mail to: laoshi1998@outlook.com" rel="nofollow">xgon</a>
 * @version 1.0.0
 */
@RestController
@RequestMapping("/parent")
public class ParentController {
    private ParentService parentService;

    @Autowired
    public void setParentService(ParentService parentService) {
        this.parentService = parentService;
    }


    @PostMapping("/addParent")
    public ApiResponse addParent(@RequestBody Parent parent) {
        parentService.addParent(parent);
        return ApiResponse.SUCCESS.setData("添加信息成功");
    }

    @PostMapping("/editParent")
    public ApiResponse editParent(@RequestBody Parent parent) {
        parentService.editParent(parent);
        return ApiResponse.SUCCESS.setData("修改信息成功");
    }

    @PostMapping("/removeParent")
    public ApiResponse removeStudent(@RequestBody Parent parent) {
        parentService.removeParent(parent);
        return ApiResponse.SUCCESS.setData("移除信息成功");
    }

    @PostMapping("/page")
    public ApiResponse page(@RequestBody Map<String, Object> models) {
        Page page = new Page();
        page.setPageSize((Integer) models.get("size"));
        page.setCurrentPageNum((Integer) models.get("current"));
        page.buildStartIndex();

        Parent parent = new ObjectMapper()
                .convertValue(models.get("data"), new TypeReference<>() {
                });

        parentService.queryParent(page, parent);

        return ApiResponse.SUCCESS.setData(page);
    }
}

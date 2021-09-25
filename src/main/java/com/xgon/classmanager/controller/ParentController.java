package com.xgon.classmanager.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xgon.classmanager.api.ResultCode;
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
    public ResultCode addParent(@RequestBody Parent parent) {
        parentService.addParent(parent);
        return ResultCode.SUCCESS.setData("添加信息成功");
    }

    @PostMapping("/editStudent")
    public ResultCode editStudent(@RequestBody Parent parent) {
        parentService.editParent(parent);
        return ResultCode.SUCCESS.setData("修改信息成功");
    }

    @PostMapping("/removeStudent")
    public ResultCode removeStudent(@RequestBody Parent parent) {
        parentService.removeParent(parent);
        return ResultCode.SUCCESS.setData("移除信息成功");
    }

    @PostMapping("/page")
    public ResultCode page(@RequestBody Map<String, Object> models) {
        Page page = new Page();
        page.setPageSize((Integer) models.get("size"));
        page.setCurrentPageNum((Integer) models.get("current"));
        page.buildStartIndex();

        // models.get("data") 返回的对象的类型是 LinkedHashMap 类型的，将LinkedHashMap对象转换成json，在将json转换成Student对象
        Parent parent = new ObjectMapper()
                .convertValue(models.get("data"), new TypeReference<>() {
                });

        parentService.queryParent(page, parent);

        /// HashMap<String, Object> data = new HashMap<>(3);
        /// data.put("records", page.getRecords());
        /// data.put("parents", 2);
        /// data.put("page", page);
        return ResultCode.SUCCESS.setData(page);
    }
}

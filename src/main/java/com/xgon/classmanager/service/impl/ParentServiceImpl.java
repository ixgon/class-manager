package com.xgon.classmanager.service.impl;

import com.xgon.classmanager.common.Page;
import com.xgon.classmanager.entity.Parent;
import com.xgon.classmanager.mapper.ParentMapper;
import com.xgon.classmanager.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>FileName:&ensp;com.xgon.classmanager.service.impl.<strong>ParentServiceImpl.java</strong></p>
 * <p>Date:&ensp;2021/9/25 19:18</p>
 * <p>Description:&ensp;提供每位家长信息的增删改查服务接口实现</p>
 *
 * @author <a href="mail to: laoshi1998@outlook.com" rel="nofollow">xgon</a>
 * @version 1.0.0
 */
@Service
public class ParentServiceImpl implements ParentService {
    private ParentMapper parentMapper;

    @Autowired
    public void setParentMapper(ParentMapper parentMapper) {
        this.parentMapper = parentMapper;
    }

    @Override
    public void addParent(Parent parent) {
        parentMapper.addParent(parent);
    }

    @Override
    public void editParent(Parent parent) {
        parentMapper.editParent(parent);
    }

    @Override
    public void removeParent(Parent parent) {
        parentMapper.removeParent(parent);
    }

    @Override
    public void queryParent(Page page, Parent parent) {
        page.setRecords(parentMapper.queryParent(page, parent));
    }
}

package com.xgon.classmanager.service;

import com.xgon.classmanager.common.Page;
import com.xgon.classmanager.entity.Parent;

/**
 * <p>FileName:&ensp;com.xgon.classmanager.service.<strong>ParentService.java</strong></p>
 * <p>Date:&ensp;2021-09-25 17:31</p>
 * <p>Description:&ensp;提供每位家长信息的增删改查服务接口</p>
 * <p color="red">这种重复行的工作使用MyBatis-Plus解决最好，如果没有用到它，可以复制StudentService的模板
 * 到Notepad++中，进行Student到Parent等的字符串全局替换（区分大小写）。</p>
 *
 * @author <a href="mail to: laoshi1998@outlook.com" rel="nofollow">xgon</a>
 * @version 1.0.0
 */
public interface ParentService {

    /**
     * <p>MethodName:&ensp;<strong>addParent</strong></p>
     * <p>Description:&ensp;家长新增</p>
     *
     * @param parent 家长信息
     */
    void addParent(Parent parent);

    /**
     * <p>MethodName:&ensp;<strong>editParent</strong></p>
     * <p>Description:&ensp;家长修改</p>
     *
     * @param parent 家长信息
     */
    void editParent(Parent parent);

    /**
     * <p>MethodName:&ensp;<strong>removeParent</strong></p>
     * <p>Description:&ensp;家长查询</p>
     *
     * @param parent 家长（部分）信息
     */
    void removeParent(Parent parent);

    /**
     * <p>MethodName:&ensp;<strong>queryParent</strong></p>
     * <p>Description:&ensp;家长查询</p>
     *
     * @param page   查询分页对象
     * @param parent 家长（部分）信息
     */
    void queryParent(Page page, Parent parent);
}

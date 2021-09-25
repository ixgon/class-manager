package com.xgon.classmanager.mapper;

import com.xgon.classmanager.common.Page;
import com.xgon.classmanager.entity.Parent;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>FileName:&ensp;com.xgon.classmanager.mapper.<strong>ParentMapper.java</strong></p>
 * <p>Date:&ensp;2021/9/25 19:19</p>
 * <p>Description:&ensp;与数据库进行交互，持久化数据，为家长信息操作（增删改查）服务提供支持</p>
 *
 * @author <a href="mail to: laoshi1998@outlook.com" rel="nofollow">xgon</a>
 * @version 1.0.0
 */
@Mapper
public interface ParentMapper {

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
     * @param page    查询分页对象
     * @param parent 家长（部分）信息
     */
    void queryParent(Page page, Parent parent);
}

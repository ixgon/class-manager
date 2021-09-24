package com.xgon.classmanager.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <p>FileName:&ensp;com.xgon.classmanager.entity.<strong>Classroom.java</strong></p>
 * <p>Date:&ensp;2021-09-24 8:46</p>
 * <p>Description:&ensp;班级表</p>
 *
 * @author <a href="mail to: laoshi1998@outlook.com" rel="nofollow">xgon</a>
 * @version 1.0.0
 */
public class Classroom {
    private Integer id;
    /**
     * <p>Description:&ensp;班级名称</p>
     */
    private String name;
    /**
     * <p>Description:&ensp;年级</p>
     */
    private String year;
    private String createTime;
    private String updateTime;
    @JsonProperty(value = "isDeleted")
    private Integer isDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}

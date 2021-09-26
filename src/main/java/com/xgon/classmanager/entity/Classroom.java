package com.xgon.classmanager.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>FileName:&ensp;com.xgon.classmanager.entity.<strong>Classroom.java</strong></p>
 * <p>Date:&ensp;2021-09-24 8:46</p>
 * <p>Description:&ensp;班级表</p>
 *
 * @author <a href="mail to: laoshi1998@outlook.com" rel="nofollow">xgon</a>
 * @version 1.0.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Classroom implements Serializable {
    private static final long serialVersionUID = 42L;

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
    private Integer isDeleted;
    private List<Student> students;

    @JsonProperty(value = "isDeleted")
    public Integer getDeleted() {
        return isDeleted;
    }

    @JsonProperty(value = "isDeleted")
    public void setDeleted(Integer deleted) {
        isDeleted = deleted;
    }
}

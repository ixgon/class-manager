package com.xgon.classmanager.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * <p>FileName:&ensp;com.xgon.classmanager.entity.<strong>Parent.java</strong></p>
 * <p>Date:&ensp;2021-09-24 8:45</p>
 * <p>Description:&ensp;家长表</p>
 *
 * @author <a href="mail to: laoshi1998@outlook.com" rel="nofollow">xgon</a>
 * @version 1.0.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Parent extends Person implements Serializable {
    private String phone;
    private List<Student> students;
}

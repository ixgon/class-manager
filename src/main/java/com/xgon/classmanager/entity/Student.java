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
 * <p>FileName:&ensp;com.xgon.classmanager.entity.<strong>Student.java</strong></p>
 * <p>Date:&ensp;2021-09-23 17:30</p>
 * <p>Description:&ensp;学生表</p>
 * <P>@JsonInclude(JsonInclude.Include.NON_EMPTY) 与 @JsonInclude(JsonInclude.Include.NON_NULL)</P>
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
public class Student extends Person implements Serializable {
    private String idCard;
    /**
     * <p>Description:&ensp;过去一个学生只能对应一个班级，现在一个学生可以从属于多个班级</p>
     * <b>过去： {@code private Classroom classroom}</b>
     */
    private List<Classroom> classrooms;
    private List<Parent> parents;
}

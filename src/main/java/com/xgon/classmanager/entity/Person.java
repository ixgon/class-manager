package com.xgon.classmanager.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>FileName:&ensp;com.xgon.classmanager.entity.<strong>Person.java</strong></p>
 * <p>Date:&ensp;2021-09-24 12:21</p>
 * <p>Description:&ensp;学生和家长等人的抽象类</p>
 *
 * @author <a href="mail to: laoshi1998@outlook.com" rel="nofollow">xgon</a>
 * @version 1.0.0
 */
@Data
public abstract class Person implements Serializable {
    private static final long serialVersionUID = 42L;

    protected Integer id;
    protected String account;
    protected String password;
    protected String name;
    /**
     * <p>Description:&ensp;1：男 &emsp; 2：女</p>
     */
    protected Integer sex;
    protected String createTime;
    protected String updateTime;
    /**
     * <p>Description:&ensp;删除此人的信息标志位（并非真正的删除）</p>
     * <p>注意。因为是is开头的属性，在进行json解析时，会将其属性名中的is去掉。调用的是 getDeleted() 而非getIsDeleted()，
     * 所以这里需要@JsonProperty注解进行属性名解析的映射。
     * 需要注意的是@JsonProperty(value = "isDeleted")不能加在这里的属性上，要加在下面的getter和setter方法上。
     * 这是因为如果加在属性上。jackson按属性解析一回，还会按下面的getDeleted方法解析一回，这就导致对象序列化后的json字符串
     * 中除了包含一个is_deleted字段，还会包含一个deleted属性！！！
     * 我们还可以在属性上添加@JsonProperty(value = "isDeleted")，去掉相应的getter和setter方法。
     * 由于isDeleted是私有属性，为了方便外接访问它，最好还是要提供getter和setter方法，所以推荐使用方法一解决这个问题。
     * <br/>
     * <a href="https://www.cnblogs.com/Zzwena/p/13744846.html">Java属性为什么不能是is开头的boolean</a></p>
     */
    protected Integer isDeleted;

    @JsonProperty(value = "isDeleted")
    public Integer getDeleted() {
        return isDeleted;
    }

    @JsonProperty(value = "isDeleted")
    public void setDeleted(Integer deleted) {
        isDeleted = deleted;
    }
}

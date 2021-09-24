package com.xgon.classmanager.entity;

import java.io.Serializable;

/**
 * <p>FileName:&ensp;com.xgon.classmanager.entity.<strong>Person.java</strong></p>
 * <p>Date:&ensp;2021-09-24 12:21</p>
 * <p>Description:&ensp;学生和家长等人的抽象类</p>
 *
 * @author <a href="mail to: laoshi1998@outlook.com" rel="nofollow">xgon</a>
 * @version 1.0.0
 */
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
    protected Boolean isDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
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

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}

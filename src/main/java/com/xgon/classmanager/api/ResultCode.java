package com.xgon.classmanager.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * <p>FileName:&ensp;com.xgon.classmanager.api.<strong>ResultCode.java</strong></p>
 * <p>Date:&ensp;2021/9/23 22:52</p>
 * <p>Description:&ensp;全局响应码</p>
 * <pre>
 *     // controller层的一个方法
 *     public ResultCode test() {
 *         return ResultCode.SUCCESS; // Spring MVC 底层会默认使用jackson将对象序列化为字符串
 *     }
 *
 *     // 多级嵌套的json字符串，会被 Spring MVC 底层调用 jackson 解析成多级嵌套的 java.util.LinkedHashMap
 *     public ResultCode page(@RequestBody Map<String, Object> models)
 * </pre>
 * <a href="https://blog.csdn.net/skyupward/article/details/105088051">配置枚举类型在Jackson中的序列化方式</a>
 * <p>对于枚举对象，Spring MVC 底层返回枚举属性值，如SUCCESS(200, "success")，返回对象名字符串化后的结果，而非对象承载的内容。
 * 使用 @JsonFormat 解决这个问题，@JsonProperty配置jackson序列化对象时字段值对应的自定义key；
 * 使用 @JsonInclude 配置jackson不序列化也不包含值为空的字段。</p>
 *
 * @author <a href="mail to: laoshi1998@outlook.com" rel="nofollow">xgon</a>
 * @version 1.0.0
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ResultCode implements Serializable {
    /**
     * <p>Description:&ensp;成功</p>
     */
    SUCCESS(200, "success"),
    /**
     * <p>Description:&ensp;失败</p>
     */
    FAILURE(201, "failure");

    private static final long serialVersionUID = 42L;

    /**
     * <p>Description:&ensp;响应(/返回)码</p>
     */
    @JsonProperty(value = "code")
    private final int CODE;
    /**
     * <p>Description:&ensp;响应(/返回)消息</p>
     */
    @JsonProperty(value = "msg")
    private final String MSG;
    /**
     * <p>Description:&ensp;响应(/返回)数据</p>
     */
    @JsonProperty(value = "data")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Serializable data;

    ResultCode(int code, String msg) {
        this.CODE = code;
        this.MSG = msg;
    }

    ResultCode(int code, String msg, Serializable data) {
        this.CODE = code;
        this.MSG = msg;
        this.data = data;
    }

    public ResultCode setData(Serializable data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {

        return "ResultCode{" +
                "code=" + CODE +
                ", msg='" + MSG + '\'' +
                ", data=" + data +
                '}';
    }
}

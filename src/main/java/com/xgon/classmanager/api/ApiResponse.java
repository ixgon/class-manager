package com.xgon.classmanager.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>FileName:&ensp;com.xgon.classmanager.api.<strong>ApiResponse.java</strong></p>
 * <p>Date:&ensp;2021/9/23 22:52</p>
 * <p>Description:&ensp;全局响应码</p>
 * <pre>
 *     // controller层的一个方法
 *     public ApiResponse test() {
 *         return ApiResponse.SUCCESS; // Spring MVC 底层会默认使用jackson将对象序列化为字符串
 *     }
 *
 *     // 多级嵌套的json字符串，会被 Spring MVC 底层调用 jackson 解析成多级嵌套的 java.util.LinkedHashMap
 *     public ApiResponse page(@RequestBody Map<String, Object> models)
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
@JsonInclude(JsonInclude.Include.NON_NULL)
@Accessors(chain = true)
public enum ApiResponse implements Serializable {
    /**
     * <p>Description:&ensp;成功</p>
     */
    SUCCESS(200, "success"),
    /**
     * <p>Description:&ensp;未知错误</p>
     */
    UNKNOWN("1000", "unknown!"),
    /**
     * <p>Description:&ensp;失败</p>
     */
    FAILURE("1001", "failure"),
    /**
     * <p>Description:&ensp;空指针异常</p>
     */
    NULL_POINTER_EXCEPTION("1002", "null pointer exception!"),
    /**
     * <p>Description:&ensp;服务器内部错误</p>
     */
    INTERNAL_SERVER_ERROR("1111", "internal server error!");

    private static final long serialVersionUID = 42L;

    /**
     * <p>Description:&ensp;【正确】响应(/返回)码</p>
     */
    @JsonProperty(value = "code")
    private Integer code;
    /**
     * <p>Description:&ensp;【正确】响应(/返回)消息</p>
     */
    @JsonProperty(value = "msg")
    private String msg;

    /**
     * <p>Description:&ensp;【错误】响应(/返回)码</p>
     */
    @JsonProperty(value = "error_code")
    private String errorCode;
    /**
     * <p>Description:&ensp;【错误】响应(/返回)消息</p>
     */
    @JsonProperty(value = "error_msg")
    private String errorMsg;

    /**
     * <p>Description:&ensp;响应(/返回)数据</p>
     */
    @JsonProperty(value = "data")
    @Setter
    private Serializable data;

    ApiResponse(@NonNull Integer code, @NonNull String msg) {
        this.code = code;
        this.msg = msg;
    }

    ApiResponse(@NonNull String errorCode, @NonNull String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}

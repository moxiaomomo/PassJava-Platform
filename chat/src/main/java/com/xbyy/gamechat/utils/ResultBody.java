package com.xbyy.gamechat.utils;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xbyy.gamechat.enums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

/**
 * @author admin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultBody<T> implements Serializable {

    private static final long serialVersionUID = -1638628582858302625L;
    /**
     * 响应编码
     */
    private int code = 200;
    /**
     * 提示消息
     */
    private String message;

    /**
     * 请求路径
     */
    private String path;

    /**
     * 响应数据
     */
    private T data;

    /**
     * http状态码
     */
    private int httpStatus;

    /**
     * 附加数据
     */
    private Map<String, Object> extra;

    /**
     * 响应时间
     */
    private long timestamp = System.currentTimeMillis();


    @JSONField(serialize = false, deserialize = false)
    @JsonIgnore
    public int getHttpStatus() {
        return httpStatus;
    }


    /**
     * 响应成功
     */
    public static ResultBody ok() {
        return new ResultBody().code(ErrorCode.OK.getCode()).msg(ErrorCode.OK.getMessage());
    }

    /**
     * 响应失败
     * @return
     */
    public static ResultBody failed() {
        return new ResultBody().code(ErrorCode.FAIL.getCode()).msg(ErrorCode.FAIL.getMessage());
    }

    public ResultBody code(int code) {
        this.code = code;
        return this;
    }

    public ResultBody msg(String message) {
        this.message = ErrorCode.getResultEnum(this.code).getMessage();
        return this;
    }

    public ResultBody data(T data) {
        this.data = data;
        return this;
    }

    public ResultBody path(String path) {
        this.path = path;
        return this;
    }

    public ResultBody httpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
        return this;
    }

    public ResultBody put(String key, Object value) {
        this.extra.put(key, value);
        return this;
    }
}

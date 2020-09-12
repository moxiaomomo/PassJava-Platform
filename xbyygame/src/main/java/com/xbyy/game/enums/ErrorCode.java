package com.xbyy.game.enums;

/**
 * 自定义返回码
 *
 * @author admin
 */

public enum ErrorCode {
    /**
     * 成功
     */
    OK(200, "success"),
    FAIL(500, "fail"),
    ALERT(1001, "alert"),
    NO_DATA(0,"暂无数据!"),

    /**
     * 系统错误
     */
    ERROR(5000, "error"),
    GATEWAY_TIMEOUT(5004, "gateway_timeout"),
    SERVICE_UNAVAILABLE(5003, "service_unavailable"),
    FILE_KEY_EXPIRE(5005,"file key is expired"),
    REPORT_LOCATION_ERROR(5006,"report location is error"),

    USER_NOT_EXIST(6001,"用户不存在"),;


    private int code;
    private String message;

    ErrorCode() {
    }

    private ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ErrorCode getResultEnum(int code) {
        for (ErrorCode type : ErrorCode.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return ERROR;
    }

    public static ErrorCode getResultEnum(String message) {
        for (ErrorCode type : ErrorCode.values()) {
            if (type.getMessage().equals(message)) {
                return type;
            }
        }
        return ERROR;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}


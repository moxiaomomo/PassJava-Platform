package com.xbyy.game.enums;

public enum CommonStateEnum {
    NORMAL(1, "正常"),
    ABNORMAL(2, "异常"),
    UNKNOWN(3, "未知");

    private Integer status;
    private String message;

    public Integer getState() {
        return status;
    }

    public void setState(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private CommonStateEnum(Integer state, String message) {
        this.status = state;
        this.message = message;
    }

    public static String getMsgByType(Integer type) {
        for (CommonStateEnum state : CommonStateEnum.values()) {
            if (state.getState().equals(type)) {
                return state.getMessage();
            }
        }
        return null;
    }
}

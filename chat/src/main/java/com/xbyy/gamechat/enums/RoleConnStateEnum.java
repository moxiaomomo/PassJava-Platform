package com.xbyy.gamechat.enums;

public enum RoleConnStateEnum {
    NORMAL(1, "正常"),
    LEAVE(2, "离开");

    private Integer status;
    private String message;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private RoleConnStateEnum(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public static String getMsgByType(Integer type) {
        for (RoleConnStateEnum state : RoleConnStateEnum.values()) {
            if (state.getStatus().equals(type)) {
                return state.getMessage();
            }
        }
        return null;
    }
}

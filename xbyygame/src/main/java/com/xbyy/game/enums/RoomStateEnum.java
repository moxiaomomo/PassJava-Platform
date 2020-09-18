package com.xbyy.game.enums;

public enum RoomStateEnum {
    NORMAL(0, "正常"),
    CLOSED(1, "关闭"),
    BANNED(2, "禁用");

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

    private RoomStateEnum(Integer state, String message) {
        this.status = state;
        this.message = message;
    }

    public static String getMsgByType(Integer type) {
        for (RoleStateEnum state : RoleStateEnum.values()) {
            if (state.getState().equals(type)) {
                return state.getMessage();
            }
        }
        return null;
    }
}

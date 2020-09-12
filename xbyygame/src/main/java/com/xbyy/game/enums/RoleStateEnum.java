package com.xbyy.game.enums;

public enum RoleStateEnum {
    NORMAL(1, "正常"),
    OUT(2, "淘汰");

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

    private RoleStateEnum(Integer state, String message) {
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

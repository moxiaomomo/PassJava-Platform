package com.xbyy.gamechat.enums;

/**
 * @Description 房间角色类型
 * @Author moguang
 * @Date 2020/09/10
 **/
public enum RoleTypeEnum {

    PM(1, "平民"),
    WD(2, "卧底"),
    BWD(3, "白板卧底"),
    VIEWER(4, "观众");

    private Integer type;
    private String message;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private RoleTypeEnum(Integer type, String message) {
        this.type = type;
        this.message = message;
    }

    public static String getMsgByType(Integer type) {
        for (RoleTypeEnum typeEnum : RoleTypeEnum.values()) {
            if (typeEnum.getType().equals(type)) {
                return typeEnum.getMessage();
            }
        }
        return null;
    }
}


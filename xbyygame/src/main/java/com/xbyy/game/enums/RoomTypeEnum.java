package com.xbyy.game.enums;

public enum RoomTypeEnum {
    SSWD(1, "谁是卧底"),
    KBWD(2, "白板卧底"),
    WZQ(3, "五子棋"),
    ZSZQ(4, "桌式足球");

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

    private RoomTypeEnum(Integer type, String message) {
        this.type = type;
        this.message = message;
    }

    public static String getMsgByType(Integer type) {
        for (RoomTypeEnum typeEnum : RoomTypeEnum.values()) {
            if (typeEnum.getType().equals(type)) {
                return typeEnum.getMessage();
            }
        }
        return null;
    }
}

package com.xbyy.game.enums;

public enum GameModeEnum {
    SSWD(0, "谁是卧底"),
    KBWD(1, "白板卧底"),
    WZQ(2, "五子棋"),
    ZSZQ(3, "桌式足球");

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

    private GameModeEnum(Integer type, String message) {
        this.type = type;
        this.message = message;
    }

    public static String getMsgByType(Integer type) {
        for (GameModeEnum typeEnum : GameModeEnum.values()) {
            if (typeEnum.getType().equals(type)) {
                return typeEnum.getMessage();
            }
        }
        return null;
    }
}

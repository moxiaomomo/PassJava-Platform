package com.xbyy.game.enums;

public enum GameFlagEnum {
    VOICE(0, "语音模式"), // default
    TEXT(1, "文字模式");

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

    private GameFlagEnum(Integer type, String message) {
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
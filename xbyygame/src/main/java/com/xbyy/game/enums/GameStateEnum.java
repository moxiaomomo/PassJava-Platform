package com.xbyy.game.enums;

/**
 * @Description 房间状态  游戏状态 1-准备阶段 2-发言阶段 3-投票阶段 4-游戏结束
 * @Author moguang
 * @Date 2020/09/10
 **/
public enum GameStateEnum {

    PREPARE(0, "准备中"),
    DESC(1, "发言中"),
    VOTE(2, "投票中"),
    GAME_OVER(2, "游戏结束");

    private Integer status;
    private String message;

    public Integer getState() {
        return status;
    }

    public void setState(Integer state) {
        this.status = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private GameStateEnum(Integer state, String message) {
        this.status = state;
        this.message = message;
    }

    public static String getMsgByType(Integer type) {
        for (GameStateEnum operType : GameStateEnum.values()) {
            if (operType.getState().equals(type)) {
                return operType.getMessage();
            }
        }
        return null;
    }
}


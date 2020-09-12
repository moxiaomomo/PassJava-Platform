package com.xbyy.game.enums;

public enum MsgEventTypeEnum {

    ROOM_CREATE(1, "创建房间"),
    ROOM_JOIN(2, "加入房间"),
    ROOM_FULL(3, "房间满员"),
    ROOM_QUIT(4, "正常退出房间"),
    ROOM_QUIT_WHEN_READY(5, "准备期间退出房间"),
    ROOM_QUIT_WHEN_PLAY(6, "游戏期间退出房间"),
    ROOM_KICK(7, "被踢出房间"),
    GAME_START(8, "通知游戏开始"),
    GAME_JOIN(9, "该房间成员已满"),
    GAME_KICK(10, "游戏中退出房间"),
    GAME_STATE(11, "推送游戏状态信息"),
    GAME_END(12, "游戏结束"),
    ROLE_INIT(13, "角色指派"),
    ROLE_OUT(14, "角色被淘汰"),
    ROLE_STATE(15, "推送玩家状态信息"),
    DESC_START(16, "开始发言"),
    DESC_TIMEOUT(17, "发言超时，则结束"),
    DESC_END(18, "发言后角色主动结束"),
    VOTE_USERS(19, "推送要投票及要被投票的玩家列表"),
    VOTE_START(20, "开始投票"),
    VOTE_ONE(21, "投票给某个玩家"),
    VOTE_TIMEOUT(22, "投票超时"),
    VOTE_END(23, "全体投票结束"),
    VOTE_RES(24, "投票结果推送"),
    CHAT_MSG(25, "聊天室信息"),
    HB_CHECK(26, "心跳检查");

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

    private MsgEventTypeEnum(Integer type, String message){
        this.type = type;
        this.message = message;
    }

    public static String getMsgByType(Integer type) {
        for (MsgEventTypeEnum typeEnum : MsgEventTypeEnum.values()) {
            if (typeEnum.getType().equals(type)) {
                return typeEnum.getMessage();
            }
        }
        return null;
    }
}

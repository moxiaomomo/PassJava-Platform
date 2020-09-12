package com.xbyy.game.pojo.dto;

import lombok.Data;

/**
 * @Description TODO
 * @Author moguang
 * @Date 2020/9/9
 **/
@Data
public class RoomInfoToRedis {
    /**
     * 房间id
     */
    private String roomId;

    /**
     * 房间类型
     */
    private Integer roomType;

    /**
     * 游戏状态 1-准备阶段 2-描述阶段 3-投票阶段 4-游戏结束
     */
    private Integer gameState;

    /**
     * 描述阶段的票数
     */
    private Integer descVoteCount;

    /**
     * 当前描述的位置(玩家序号)
     */
    private Integer descPosition;

    /**
     * 房间定义的总玩家
     */
    private Integer playerCnt;

    /**
     * 房间定义的总卧底
     */
    private Integer wdCnt;

    /**
     * 房间游戏观看人数
     */
    private Integer viewerCnt;

    /**
     * 房间白板规则 0-随机 1-需要 2-不需要
     */
    private Integer whiteBanRule;

    /**
     * 选词规则 默认：随机
     */
    private Integer selectWordRule;

    /**
     * 计算投票倒计时的时间戳
     */
    private long endTime;
}

package com.xbyy.game.pojo.dto;

import com.xbyy.game.enums.GameStateEnum;
import com.xbyy.game.pojo.entity.GameRoom;
import lombok.Data;

import java.lang.reflect.Field;

/**
 * @Description TODO
 * @Author moguang
 * @Date 2020/9/9
 **/
@Data
public class RoomInfoToRedis extends GameRoom {
    /**
     * 游戏状态 0-准备阶段 1-描述阶段 2-投票阶段 3-游戏结束
     */
    private GameStateEnum gameState;

    /**
     * 有效总票数
     */
    private Integer voteTotalNum;

    /**
     * 当前投票阶段第几次投票(最多两次), 0 / 1 / 2
     */
    private Integer voteRound;

    /**
     * 当前描述的位置(玩家序号)
     */
    private Integer descPos;

    /**
     * 房间白板规则 0-随机 1-需要 2-不需要
     */
    private Integer bbRule;

    /**
     * 选词规则 默认：随机
     */
    private Integer selectWordRule;

    /**
     * 计算投票倒计时的时间戳
     */
    private long endTime;

    public RoomInfoToRedis() {

    }

    public RoomInfoToRedis(GameRoom gr) {
        Class<?> classType = gr.getClass();
        for (Field field : classType.getDeclaredFields()) {
            field.setAccessible(true);//设置可访问权限
            try {
                field.set(this, field.get(this));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}

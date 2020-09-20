package com.xbyy.game.pojo.dto;

import com.xbyy.game.enums.GameModeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description sswd room params
 * @Author moguang
 * @Date 2020/9/12
 **/
@Data
@NoArgsConstructor
public class SSWDRoomParam {
    // roomId
    private String roomId;
    // roomName
    private String roomName;
    // 玩家人数
    private Integer playerNum;
    // 卧底人数
    private Integer wdNum;
    // 观众人数
    private Integer viewerNum;
    // 白板规则 (游戏模式1)
    private Integer bbRule;
    // 选词规则
    private Integer wordGenRule;
    // 房间类型 0-语音版 1-文字版
    private Integer roomFlag;
    // 游戏模式 0-谁是卧底 1-白板卧底
    private GameModeEnum gameMode;
}

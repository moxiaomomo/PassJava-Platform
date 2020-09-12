package com.xbyy.gamechat.pojo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description sswd room ey params
 * @Author moguang
 * @Date 2020/9/12
 **/
@Data
@NoArgsConstructor
public class SSWDRoomParam {
    // 玩家人数
    private Integer playerNum;
    // 卧底人数
    private Integer wdNum;
    // 观众人数
    private Integer viewerNum;
    // 白板规则 (游戏模式1)
    private Integer blankRule;
    // 选词规则
    private Integer wordGenRule;
    // roomId
    private String roomId;
    // 游戏模式 0-谁是卧底 1-白板卧底
    private Integer roomType;
    // 房间类型 0-语音版 1-文字版
    private Integer roomFlag;
}

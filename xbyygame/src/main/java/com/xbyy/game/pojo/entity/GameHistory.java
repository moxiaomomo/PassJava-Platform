package com.xbyy.game.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 *
 * @author moguang
 * @date 2020-09-10
 */
@Data
@TableName("tbl_gamehis")
public class GameHistory implements Serializable {

    private static final long serialVersionUID = -153782320286949290L;
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    // 玩家id、位置、角色、结果(win/lose)、得分
    private String userId;
    private Integer position;
    private Integer role;
    private Integer result;
    private Integer score;
    // 参与状态：中途退出、完整参与、开小差等
    private Integer status;
    // 被投诉次数
    private Integer reportedCnt;

    // 房间号、房间类型
    private String roomId;
    private Integer roomType; // 哪种游戏模式

    // 开始、结束时间
    private Date startAt;
    private Date endAt;

    private Integer flag;
}

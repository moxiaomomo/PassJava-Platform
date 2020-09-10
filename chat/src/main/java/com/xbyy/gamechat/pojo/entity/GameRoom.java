package com.xbyy.gamechat.pojo.entity;

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
@TableName("tbl_gameroom")
public class GameRoom implements Serializable {

    private static final long serialVersionUID = -153782320286949290L;
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    // 房间号、房间类型、房间状态
    private String roomId;
    private Integer roomType; // 哪种游戏模式
    private Integer status;

    // 创建者、更新者
    private String createUser;
    private String updateUser;

    private Integer flag;

    // 创建日期、最近更新日期
    private Date createAt;
    private Date updateAt;

    // 参玩人数、卧底数、观看人数
    private Integer playerCnt;
    private Integer wdCnt;
    private Integer viewerCnt;

    // 当前版本没用到
    private Integer whiteBanRule;
    private Integer selectWordRule;
}

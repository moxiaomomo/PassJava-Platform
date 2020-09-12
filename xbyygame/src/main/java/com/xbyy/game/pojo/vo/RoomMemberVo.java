package com.xbyy.game.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description TODO
 * @Author moguang
 * @Date 2020/9/9
 **/
@Data
public class RoomMemberVo implements Serializable {

    private static final long serialVersionUID = 7372688277174245616L;
    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户位置
     */
    private Integer position;

    /**
     * 头像
     */
    private String avatarUrl;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 状态 1-正常 2-淘汰
     */
    private Integer roleState;

    /**
     * 状态 中文说明
     */
    private String roleStateStr;

    /**
     * 在线状态 1-正常 2-离开
     */
    private Integer onlineStatus;

    /**
     * 在线状态 1-正常 2-离开
     */
    private String onlineStatusStr;

    /**
     * 类型 1-平民 2-卧底 3-白板(卧底)
     */
    private Integer type;

    /**
     * 类型 中文说明
     */
    private String typeStr;

    /**
     * 词汇
     */
    private String word;

    /**
     * 投票次数
     */
    private Integer voteCount;

    /**
     * 投票人集合
     */
    private List<VoteMemberVo> voteMembers;
}

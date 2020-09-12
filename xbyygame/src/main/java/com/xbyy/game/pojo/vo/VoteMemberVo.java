package com.xbyy.game.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description 投票人role
 * @Author moguang
 * @Date 2020/9/9
 **/
@Data
public class VoteMemberVo implements Serializable {
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
}

package com.xbyy.game.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("xbyy_user")
public class User implements Serializable {

    private static final long serialVersionUID = 3744728157627023727L;
    /**
     * 主键
     */
    @TableId
    private Long id;

    //昵称
    private String username;
    //性别
    private Integer gender;
    //出生日期
    private Date birthday;
    //注册时间
    private Date registerTime;
    //最后登录时间
    private Date lastLoginTime;
    //最后登录Ip
    private String lastLoginIp;
    //会员等级
    private Integer userLevelId;
    //别名
    private String nickname;
    //手机号码
    private String mobile;
    //注册Ip
    private String registerIp;
    //头像
    private String avatarUrl;
}

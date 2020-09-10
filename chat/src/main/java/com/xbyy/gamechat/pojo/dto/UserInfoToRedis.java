package com.xbyy.gamechat.pojo.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description TODO
 * @Author moguang
 * @Date 2020/9/9
 **/
@Data
public class UserInfoToRedis implements Serializable {
    private static final long serialVersionUID = 701154559008676465L;
    //主键
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
    //注册Ip
    private String registerIp;
    //最后登录时间
    private Date lastLoginTime;
    //最后登录Ip
    private String lastLoginIp;
    //会员等级
    private Integer userLevel;
    //别名
    private String nickname;
    //手机号码
    private String mobile;
    //头像
    private String avatarUrl;
}

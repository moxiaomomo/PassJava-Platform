package com.xbyy.game.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xbyy.game.pojo.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 *
 * @author moguang
 * @date 2020-09-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
// @NoArgsConstructor
@TableName("sswd_word")
public class SSWDWord extends BaseEntity {

    private static final long serialVersionUID=1L;

    @TableId(value = "id")
    private String id;

    private String pmWord;

    private String wdWord;

    private Integer status;

    private Long createUser;

    private Long updateUser;

    // 同步状态
    private Integer synStatus;
}
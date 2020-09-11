package com.xbyy.gamechat.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.xbyy.gamechat.pojo.common.BaseEntity;
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
@NoArgsConstructor
public class BlankWDWord extends BaseEntity {

    private static final long serialVersionUID=1L;

    @TableId(value = "id")
    private String id;

    private String pmWord;

    private Integer status;

    private Long createUser;

    private Long updateUser;

    // 同步状态
    private Integer synStatus;
}

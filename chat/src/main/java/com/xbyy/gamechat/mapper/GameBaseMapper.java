package com.xbyy.gamechat.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import com.xbyy.gamechat.config.mybatis.EntityMap;

import java.util.List;

public interface GameBaseMapper<T> extends BaseMapper<T> {
    // ew: mapper方法里的@Param(Constants.WRAPPER) Wrapper query对象; Constants.WRAPPER的值为ew
    IPage<T> pageList(Page<T> page, @Param("ew") Wrapper<?> wrapper);

    List<EntityMap> getEntityMap(@Param("ew") Wrapper<?> wrapper);
}
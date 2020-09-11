package com.xbyy.gamechat.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import com.xbyy.gamechat.config.EntityMap;

import java.util.List;

public interface GameBaseMapper<T> extends BaseMapper<T> {
    IPage<T> pageList(Page<T> page, @Param("ew") Wrapper<?> wrapper);

    List<EntityMap> getEntityMap(@Param("ew") Wrapper<?> wrapper);
}
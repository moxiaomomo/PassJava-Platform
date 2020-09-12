package com.xbyy.game.config.mybatis;

public interface EnumConvertInterceptor {
    boolean convert(EntityMap map, String key, Object v);
}

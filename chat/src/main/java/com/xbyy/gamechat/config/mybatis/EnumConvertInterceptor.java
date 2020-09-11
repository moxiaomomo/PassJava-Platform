package com.xbyy.gamechat.config.mybatis;

public interface EnumConvertInterceptor {
    boolean convert(EntityMap map, String key, Object v);
}

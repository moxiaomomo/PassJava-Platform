package com.xbyy.gamechat.config;

public interface EnumConvertInterceptor {
    boolean convert(EntityMap map, String key, Object v);
}

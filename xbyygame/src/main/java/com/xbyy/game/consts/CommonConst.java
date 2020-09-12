package com.xbyy.game.consts;

/**
 * @Description common const definition
 * @Author moguang
 * @Date 2020/9/10
 * @Version 1.0
 **/
public class CommonConst {

    /**
     * 用户前缀配置
     */
    public final static String REDIS_PRE_USER = "sswd:user:";
    /**
     * 房间前缀配置
     */
    public final static String REDIS_PRE_ROOM = "sswd:room:";
    /**
     * 房间前缀配置
     */
    public final static String REDIS_PRE_ROOM_MEMBER = "sswd:roomMem:";

    /**
     * 号码配置
     */
    public final static String REDIS_PRE_NUM_LIBRARY = "sswd:cfg:";

    /**
     * 词汇配置
     */
    public final static String REDIS_PRE_WORD_LIBRARY = "sswd:cfg:word";

    /**
     * token配置
     */
    public final static String TOKEN = "Token";

    /**
     * 默认最小页码
     */
    public static final int MIN_PAGE = 0;
    /**
     * 最大显示条数
     */
    public static final int MAX_LIMIT = 999;
    /**
     * 默认页码
     */
    public static final int DEFAULT_PAGE = 1;
    /**
     * 默认显示条数
     */
    public static final int DEFAULT_LIMIT = 10;
    /**
     * 页码 KEY
     */
    public static final String PAGE_KEY = "page";
    /**
     * 显示条数 KEY
     */
    public static final String PAGE_LIMIT_KEY = "limit";
    /**
     * 排序字段 KEY
     */
    public static final String PAGE_SORT_KEY = "sort";
    /**
     * 排序方向 KEY
     */
    public static final String PAGE_ORDER_KEY = "order";
}

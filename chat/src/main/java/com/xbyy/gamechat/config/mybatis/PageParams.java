package com.xbyy.gamechat.config.mybatis;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Maps;
import com.xbyy.gamechat.consts.CommonConst;
import com.xbyy.gamechat.utils.JsonUtils;
import com.xbyy.gamechat.utils.StringUtils;

import java.io.Serializable;
import java.util.Map;

/**
 * 分页参数
 *
 * @author liuyau
 * @date 2018/07/10
 */
public class PageParams extends Page implements Serializable {
    private static final long serialVersionUID = -1710273706052960025L;
    private int page = CommonConst.DEFAULT_PAGE;
    private int limit = CommonConst.DEFAULT_LIMIT;
    private String sort;
    private String order;
    private Map<String, Object> requestMap = Maps.newHashMap();
    /**
     * 排序
     */
    private String orderBy;

    public PageParams() {
        requestMap = Maps.newHashMap();
    }

    public PageParams(Map map) {
        if (map == null) {
            map = Maps.newHashMap();
        }
        this.page = Integer.parseInt(map.getOrDefault(CommonConst.PAGE_KEY, CommonConst.DEFAULT_PAGE).toString());
        this.limit = Integer.parseInt(map.getOrDefault(CommonConst.PAGE_LIMIT_KEY, CommonConst.DEFAULT_LIMIT).toString());
        this.sort = (String) map.getOrDefault(CommonConst.PAGE_SORT_KEY, "");
        this.order = (String) map.getOrDefault(CommonConst.PAGE_ORDER_KEY, "");
        super.setCurrent(page);
        super.setSize(limit);
        map.remove(CommonConst.PAGE_KEY);
        map.remove(CommonConst.PAGE_LIMIT_KEY);
        map.remove(CommonConst.PAGE_SORT_KEY);
        map.remove(CommonConst.PAGE_ORDER_KEY);
        requestMap.putAll(map);
    }

    public PageParams(int page, int limit) {
        this(page, limit, "", "");
    }

    public PageParams(int page, int limit, String sort, String order) {
        this.page = page;
        this.limit = limit;
        this.sort = sort;
        this.order = order;
    }

    public int getPage() {
        if (page <= CommonConst.MIN_PAGE) {
            page = 1;
        }
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        if (limit > CommonConst.MAX_LIMIT) {
            limit = CommonConst.MAX_LIMIT;
        }
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getOrderBy() {
        if (StringUtils.isBlank(order)) {
            order = "asc";
        }
        if (StringUtils.isNotBlank(sort)) {
            this.setOrderBy(String.format("%s %s", StringUtils.camelToUnderline(sort), order));
        }
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public <T> T mapToObject(Class<T> t) {
        return JsonUtils.mapToObject(this.requestMap, t);
    }

    public Map<String, Object> getRequestMap() {
        return requestMap;
    }

    public void setRequestMap(Map<String, Object> requestMap) {
        this.requestMap = requestMap;
    }
}


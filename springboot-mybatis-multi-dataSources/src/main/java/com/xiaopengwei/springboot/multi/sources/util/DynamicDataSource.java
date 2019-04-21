package com.xiaopengwei.springboot.multi.sources.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * <p>
 *   动态数据源（需要继承AbstractRoutingDataSource）
 * </p>
 *
 * @author XiaoPengwei.com
 * @since 2019-04-12
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    protected Object determineCurrentLookupKey() {
        return DatabaseContextHolder.getDatabaseType();
    }
}
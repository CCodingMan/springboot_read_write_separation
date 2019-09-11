package com.ljj.springboot_read_write_separation.bean;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

/**
 * @author: ljj
 * @Date: 2019/9/10 15:11
 * @Description:
 */
public class MyRoutingDataSource extends AbstractRoutingDataSource {
    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        return DBContextHolder.get();
    }
}

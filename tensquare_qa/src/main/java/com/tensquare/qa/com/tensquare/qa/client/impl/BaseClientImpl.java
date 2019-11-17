package com.tensquare.qa.com.tensquare.qa.client.impl;

import com.tensquare.qa.com.tensquare.qa.client.BaseClient;
import entity.Result;
import entity.StatusCode;
import org.springframework.stereotype.Component;

/**
 * @author Miss`超
 * @create 2019-11-17 8:46
 */
@Component
public class BaseClientImpl implements BaseClient {
    @Override
    public Result findById(String labelId) {
        return new Result(false, StatusCode.ERROR,"熔断器触发了");
    }

    @Override
    public Result findAllLabel() {
        return new Result(false, StatusCode.ERROR,"熔断器触发了");
    }
}

package com.tensquare.qa.com.tensquare.qa.client;

import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Miss`超
 * @create 2019-11-16 14:08
 */
@FeignClient(value = "base")//使用Feign跨域调用最好写上value=""
public interface BaseClient {
    @RequestMapping(value = "/label/{labelId}",method = RequestMethod.GET)
    public Result findById(@PathVariable("labelId") String labelId);

    @RequestMapping(value = "/label",method = RequestMethod.GET)
    public Result findAllLabel();
}

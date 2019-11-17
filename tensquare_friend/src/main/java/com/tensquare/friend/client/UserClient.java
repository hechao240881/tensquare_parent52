package com.tensquare.friend.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Miss`超
 * @create 2019-11-16 20:40
 */
@FeignClient(value = "tensquare-user")
public interface UserClient {
    @RequestMapping(value = "/user/{userid}/{friendid}/{x}",method = RequestMethod.PUT)
    public void updateFanscountandfollowcount(@PathVariable(value = "userid") String userid,
                                              @PathVariable(value = "friendid") String friendid,
                                              @PathVariable(value = "x") int x);
}

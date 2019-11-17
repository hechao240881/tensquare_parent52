package com.tensquare.web.web;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Miss`超
 * @create 2019-11-17 11:40
 */
@Component
public class WebFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //得到 request 上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        //得到 request 域
        HttpServletRequest request = currentContext.getRequest();
        String header = request.getHeader("Authorization");
        if (header != null && !"".equals(header)){
            //经过网关后得不到头信息,解决方法如下
            currentContext.addZuulRequestHeader("Authorization",header);
        }
        return null;
    }
}

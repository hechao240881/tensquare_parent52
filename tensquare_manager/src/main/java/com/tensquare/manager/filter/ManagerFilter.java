package com.tensquare.manager.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Miss`超
 * @create 2019-11-17 11:13
 */
@Component
public class ManagerFilter extends ZuulFilter {

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 过滤类型
     * @return
     * pre 在执行之前过滤
     * post 在操作之后过滤
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 配置多个过滤器后的执行顺序,数字越小越先执行
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 当前过滤器是否开启
     * @return true / false
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器内执行的操作
     * @return 任何 object 的值都表示继续执行
     *          setsendzullRespponse(false) 表示不再继续执行
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        //request 域
        HttpServletRequest request = requestContext.getRequest();

        if (request.getMethod().equals("OPTIONS")){
            return null;
        }

        if (request.getRequestURI().indexOf("login") > 0){
            return null;
        }

        //得到头信息
        String header = request.getHeader("Authorization");
        if (header != null && "".equals(header)){
            if (header.startsWith("Bearer")){
                String token = header.substring(7);
                try{
                    Claims claims = jwtUtil.parseJWT(token);
                    String roles = (String) claims.get("roles");
                    if (roles.equals("admin")){
                        //把头信息转发下去,并且运行
                        requestContext.addZuulRequestHeader("Authorization",header);
                        return null;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    //终止运行
                    requestContext.setSendZuulResponse(false);
                }
            }
        }
        //终止运行
        requestContext.setSendZuulResponse(false);
        requestContext.setResponseStatusCode(403);//403权限不足
        requestContext.setResponseBody("权限不足");
        requestContext.getResponse().setContentType("text/html;charset=utf-8");
        return null;
    }
}

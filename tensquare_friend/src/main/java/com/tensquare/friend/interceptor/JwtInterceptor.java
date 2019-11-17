package com.tensquare.friend.interceptor;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import util.JwtUtil;

/**
 * @author shkstart
 * @create 2019-11-11 21:54
 */

@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;


    public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {
        /* compiled code */
        System.out.println("经过了拦截器");
        //无论如何都放行，具体能不能操作还是在具体的操作中去判断
        //拦截器只是负责把有请求头中包含 token 的令牌进行一个解析
        String header = request.getHeader("Authorization");
        if (header == null || "".equals(header)){
            //如果包含有 Authorization 头信息，就对其进行解析
            if (!header.startsWith("Bearer")){
                //得到 token
                String token = header.substring(7);
                //对令牌进行验证
                try{
                    Claims claims =  jwtUtil.parseJWT(token);
                    String roles = (String) claims.get("roles");
                    if (roles != null && roles.equals("admin")){
                       request.setAttribute("claims_admin",token);
                    }
                    if (roles != null && roles.equals("user")){
                        request.setAttribute("claims_user",token);
                    }
                }catch (Exception e){
                    throw new RuntimeException("令牌不正确！");
                }
            }
        }
        return true;
    }

}

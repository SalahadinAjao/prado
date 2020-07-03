package org.prado.interceptors;

import org.apache.commons.lang.StringUtils;
import org.prado.annotation.SkipAuth;
import org.prado.common.ApiRRException;
import org.prado.common.BaseController;
import org.prado.entity.TokenEntity;
import org.prado.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: houlintao
 * @Date:2020/7/3 下午2:08
 * @email 437547058@qq.com
 * @Version 1.0
 * token授权拦截器类，用于在执行特定的handler方法前验证用户授权
 */
@Component
public class TokenAuthorizationInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private TokenService tokenService;

    public static final String LOGIN_USER_KEY = "LOGIN_USER_KEY";
    public static final String LOGIN_TOKEN_KEY = "X-Shoulibu-Token";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("执行了拦截器的preHandle方法 "+"\n"+"request = " + request);

        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,X-Shoulibu-Token,X-URL-PATH");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));

        SkipAuth skipAuth;

        if (handler instanceof HandlerMethod){
           skipAuth =  ((HandlerMethod)handler).getMethodAnnotation(SkipAuth.class);
        }else {
            return true;
        }
        //如果此方法上有SkipAuth注解，则跳过验证，直接返回true
        if (skipAuth != null){
            return true;
        }
        //从request中的header获取token
        String token = request.getHeader(LOGIN_TOKEN_KEY);
        if (StringUtils.isBlank(token)){
            //如果header中内有token，则从请求参数获取
            token = request.getParameter(LOGIN_TOKEN_KEY);
            System.out.println("本次请求客户端的token = " + token);
        }
        if (StringUtils.isBlank(token)){
           throw  new ApiRRException("请登录",401);
        }
        //如果token不为null，则通过token属性查询到Token实体
        TokenEntity tokenEntity = tokenService.queryByToken(token);

        System.out.println("token="+tokenEntity.getToken());

        if (tokenEntity == null || tokenEntity.getExpireTime().getTime()<System.currentTimeMillis()){
            throw  new ApiRRException("token失效，请重新登录",402);
        }
        //设置userId到request里，后续根据userId，获取用户信息
        request.setAttribute(LOGIN_USER_KEY, tokenEntity.getUserId());
        return true;
    }
}

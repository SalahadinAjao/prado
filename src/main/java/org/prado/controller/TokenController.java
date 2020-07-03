package org.prado.controller;

import com.alibaba.fastjson.JSONObject;
import org.prado.annotation.SkipAuth;
import org.prado.common.BaseController;
import org.prado.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author: houlintao
 * @Date:2020/7/3 上午8:55
 * @email 437547058@qq.com
 * @Version 1.0
 */
@RestController
@RequestMapping("token")
public class TokenController extends BaseController {
    @Autowired
    private TokenService tokenService;

    @PostMapping("create")
    public Object saveToken(){
        JSONObject jsonRequest = getJsonRequest();
        //String userId = jsonRequest.getString("userId");
        Long userId = jsonRequest.getLong("userId");
        Map<String, Object> objectMap = tokenService.createToken(userId);

        return toResponsObject(0,"token创建成功！",objectMap);
    }
}

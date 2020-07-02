package org.prado.controller;

import com.alibaba.fastjson.JSONObject;
import org.prado.common.Assert;
import org.prado.common.BaseController;
import org.prado.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: houlintao
 * @Date:2020/7/2 下午4:13
 * @email 437547058@qq.com
 * @Version 1.0
 */

@RestController
@RequestMapping("/register")
public class RegisterController extends BaseController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Object register(){
        JSONObject jsonRequest = getJsonRequest();
        String mobile = jsonRequest.getString("mobile");
        String password = jsonRequest.getString("password");

        Assert.isBlank(mobile,"手机号不能为空");
        Assert.isBlank(password,"密码不能为空");

        userService.save(mobile,password);

        return toResponsSuccess("注册成功！");
    }
}

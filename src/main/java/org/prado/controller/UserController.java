package org.prado.controller;

import com.alibaba.fastjson.JSONObject;
import org.prado.common.BaseController;
import org.prado.common.Md5;
import org.prado.entity.UserVo;
import org.prado.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: houlintao
 * @Date:2020/7/2 上午10:09
 * @email 437547058@qq.com
 * @Version 1.0
 */

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @PostMapping("/save")
    @ResponseBody
    public Object saveUser() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        JSONObject jsonRequest = getJsonRequest();
        String userName = jsonRequest.getString("userName");
        String passWord = jsonRequest.getString("passWord");

        Md5 md5 = new Md5();
        String newPass = md5.EncodeByMd5(passWord);

        UserVo userVo = new UserVo();
        userVo.setUserId(559L);
        userVo.setUsername(userName);
        userVo.setPassword(newPass);
        userVo.setGender(0);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR,-17);
        calendar.add(Calendar.MONTH,-3);
        calendar.add(Calendar.WEEK_OF_MONTH,1);
        calendar.add(Calendar.DAY_OF_WEEK,3);
        Date time = calendar.getTime();

        userVo.setBirthday(time);

        calendar.add(Calendar.YEAR,-4);
        calendar.add(Calendar.MONTH,2);
        calendar.add(Calendar.WEEK_OF_MONTH,2);
        calendar.add(Calendar.DAY_OF_WEEK,-4);
        Date regist = calendar.getTime();

        userVo.setRegister_time(regist);
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE,-3);
        Date last = calendar.getTime();

        userVo.setLast_login_time(last);
        String clientIp = getClientIp();
        userVo.setLast_login_ip(clientIp);
        userVo.setUser_level_id(2);

        String nickName = jsonRequest.getString("nickName");
        String teleNumber = jsonRequest.getString("teleNumber");
        userVo.setNickname(nickName);
        userVo.setMobile(teleNumber);

        userService.save(userVo);

        return toResponsSuccess("Congratulations! 新用户注册成功！");
    }
    @PostMapping("total")
    @ResponseBody
    public Object queryTotal(){
       return userService.queryTotal();
    }

    @PostMapping("/mobile")
    @ResponseBody
    public Object queryByMobile(){
        JSONObject jsonRequest = getJsonRequest();
        String mobile = jsonRequest.getString("mobile");

        UserVo userVo = userService.queryByMobile(mobile);
        return toResponsSuccess(userVo);
    }
}

package org.prado.controller;

import org.prado.common.BaseController;
import org.prado.common.Md5;
import org.prado.dao.UserDao;
import org.prado.entity.UserVo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: houlintao
 * @Date:2020/7/1 下午5:11
 * @email 437547058@qq.com
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");
        UserDao userDao = applicationContext.getBean(UserDao.class);

        /*int total = userDao.queryTotal();
        System.out.println("数据库中查出用户记录" + total+"条");

        UserVo userVo = userDao.queryByMobile("13954036725");
        System.out.println("用户名 = " + userVo.getUsername()+"\n"+"密码 = "+userVo.getPassword());*/
        UserVo userVo = new UserVo();
        userVo.setUserId(999L);
        userVo.setUsername("没药");

        Md5 md5 = new Md5();
        String password = md5.EncodeByMd5("6666666666");

        userVo.setPassword(password);
        userVo.setGender(1);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR,-3);
        calendar.add(Calendar.MONTH,2);
        calendar.add(Calendar.DAY_OF_MONTH,2);
        Date date = calendar.getTime();

        userVo.setBirthday(date);

        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH,3);
        calendar.add(Calendar.WEEK_OF_MONTH,-3);
        calendar.add(Calendar.DAY_OF_WEEK,-5);
        Date date2 = calendar.getTime();
        userVo.setRegister_time(date2);

        calendar.setTime(new Date());
        calendar.add(Calendar.DATE,3);
        Date last_login_time = calendar.getTime();

        userVo.setLast_login_time(last_login_time);
        BaseController baseController = new BaseController();

        userVo.setLast_login_ip("2.2.2.2");

        userVo.setUser_level_id(1);
        userVo.setNickname("牛奶糖");
        userVo.setMobile("18853694102");
        userVo.setRegister_ip("12.12.12.12");


        userDao.save(userVo);
        System.out.println("数据插入成功");
    }

}

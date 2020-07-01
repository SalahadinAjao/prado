package org.prado.controller;

import org.prado.dao.UserDao;
import org.prado.entity.UserEntity;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: houlintao
 * @Date:2020/7/1 下午5:11
 * @email 437547058@qq.com
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");
        UserDao userDao = applicationContext.getBean(UserDao.class);
        UserEntity entity = new UserEntity();
        entity.setId(70);
        entity.setUserName("流沙");
        entity.setPassWord("qs,ujkvgc");
        entity.setTeleNumber("15364723658");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(new Date());
        entity.setEstabTime(date);

        userDao.save(entity);
    }

}

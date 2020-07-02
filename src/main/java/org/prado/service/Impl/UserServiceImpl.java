package org.prado.service.Impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.prado.dao.UserDao;
import org.prado.dao.UserLevelDao;
import org.prado.entity.UserVo;
import org.prado.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;

/**
 * @Author: houlintao
 * @Date:2020/7/1 下午5:04
 * @email 437547058@qq.com
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserLevelDao userLevelDao;


    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout = 3)
    public int save(UserVo userVo) {
       return userDao.save(userVo);
    }
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout = 3)
    public int save(String mobile,String password){
        UserVo userVo = new UserVo();
        userVo.setUsername(mobile);
        userVo.setMobile(mobile);
        String sha256Hex = DigestUtils.sha256Hex(password);
        userVo.setPassword(sha256Hex);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR,-1);
        calendar.add(Calendar.MONTH,3);
        Date time = calendar.getTime();

        userVo.setRegister_time(time);

        userDao.save(userVo);

        return 0;
    }

    @Override
    public int queryTotal() {
        return userDao.queryTotal();
    }

    @Override
    public UserVo queryByMobile(String mobile) {
        return userDao.queryByMobile(mobile);
    }
}

package org.prado.service.Impl;

import org.prado.dao.UserDao;
import org.prado.entity.UserVo;
import org.prado.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Override
    public int save(UserVo userVo) {
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

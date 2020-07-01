package org.prado.service.Impl;

import org.prado.dao.UserDao;
import org.prado.entity.UserEntity;
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
    public int save(UserEntity entity) {
        userDao.save(entity);
        return 0;
    }
}

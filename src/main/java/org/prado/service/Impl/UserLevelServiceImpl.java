package org.prado.service.Impl;

import org.prado.dao.UserLevelDao;
import org.prado.entity.UserLevelEntity;
import org.prado.service.UserLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: houlintao
 * @Date:2020/7/2 下午4:23
 * @email 437547058@qq.com
 * @Version 1.0
 */
@Service
public class UserLevelServiceImpl implements UserLevelService {
    @Autowired
    private UserLevelDao userLevelDao;
    @Override
    public int save(UserLevelEntity entity) {
        return userLevelDao.save(entity);
    }
}

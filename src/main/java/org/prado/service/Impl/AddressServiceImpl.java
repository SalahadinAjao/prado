package org.prado.service.Impl;

import org.prado.dao.AddressDao;
import org.prado.entity.AddressEntity;
import org.prado.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: houlintao
 * @Date:2020/7/2 下午1:25
 * @email 437547058@qq.com
 * @Version 1.0
 */

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDao addressDao;

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout = 3)
    @Override
    public int save(AddressEntity entity) {
        return addressDao.save(entity);
    }
}

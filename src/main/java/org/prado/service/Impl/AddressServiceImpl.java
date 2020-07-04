package org.prado.service.Impl;

import org.prado.dao.AddressDao;
import org.prado.entity.AddressEntity;
import org.prado.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout = 3)
    @Override
    public void update(AddressEntity entity) {
        addressDao.update(entity);
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout = 3)
    @Override
    public AddressEntity queryObject(Integer id) {
       return addressDao.queryObject(id);
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout = 3)
    @Override
    public List<AddressEntity> queryList(Map<String, Object> map) {
         return addressDao.queryList(map);
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout = 3)
    @Override
    public int queryTotal(Map<String, Object> map) {
        return addressDao.queryTotal(map);
    }

    @Override
    public int queryTotal() {
        return addressDao.queryTotal();
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout = 3)
    @Override
    public void delete(Integer id) {
         addressDao.delete(id);
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout = 3)
    @Override
    public void deleteBatch(Integer[] ids) {
        addressDao.deleteBatch(ids);
    }
}

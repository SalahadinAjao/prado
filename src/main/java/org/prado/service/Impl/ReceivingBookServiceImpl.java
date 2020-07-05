package org.prado.service.Impl;

import org.prado.dao.ReceivingBookDao;
import org.prado.entity.ReceivingBookEntity;
import org.prado.service.ReceivingBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: houlintao
 * @Date:2020/7/4 下午4:16
 * @email 437547058@qq.com
 * @Version 1.0
 */
@Service
public class ReceivingBookServiceImpl implements ReceivingBookService {
    @Autowired
    private ReceivingBookDao receivingBookDao;
    @Override
    public void save(ReceivingBookEntity entity) {
          receivingBookDao.save(entity);
    }

    @Override
    public ReceivingBookEntity queryByDate(String date) {
        return receivingBookDao.queryByDate(date);
    }

    @Override
    public void update(ReceivingBookEntity bookEntity) {
           receivingBookDao.update(bookEntity);
    }
}

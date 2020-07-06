package org.prado.service.Impl;

import org.prado.dao.ChuLiRecordDao;
import org.prado.entity.ChuLiRecordEntity;
import org.prado.service.ChuLiRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Author: houlintao
 * @Date:2020/7/6 下午12:59
 * @email 437547058@qq.com
 * @Version 1.0
 */
@Service
public class ChuLiRecordServiceImpl implements ChuLiRecordService {

    @Autowired
    private ChuLiRecordDao chuLiRecordDao;
    @Override
    public void save(ChuLiRecordEntity entity) {
          chuLiRecordDao.save(entity);
    }

    @Override
    public BigDecimal sumMoney(long id) {
        return chuLiRecordDao.sumMoney(id);
    }

    @Override
    public ChuLiRecordEntity queryByName(String name) {
        return chuLiRecordDao.queryByName(name);
    }

}

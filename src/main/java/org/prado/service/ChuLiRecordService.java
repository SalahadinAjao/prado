package org.prado.service;

import org.prado.entity.ChuLiRecordEntity;

import java.math.BigDecimal;

/**
 * @Author: houlintao
 * @Date:2020/7/6 下午12:59
 * @email 437547058@qq.com
 * @Version 1.0
 */
public interface ChuLiRecordService {

    void save(ChuLiRecordEntity entity);

    BigDecimal sumMoney(long id);

    ChuLiRecordEntity queryByName(String name);
}

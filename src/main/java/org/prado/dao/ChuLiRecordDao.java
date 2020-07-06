package org.prado.dao;

import org.prado.entity.ChuLiRecordEntity;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * @Author: houlintao
 * @Date:2020/7/6 上午10:48
 * @email 437547058@qq.com
 * @Version 1.0
 */

@Repository
public interface ChuLiRecordDao extends BaseDao<ChuLiRecordEntity>{

    @Override
    int save(ChuLiRecordEntity chuLiRecordEntity);

    BigDecimal sumMoney(long id);

    ChuLiRecordEntity queryByName(String name);
}

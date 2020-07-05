package org.prado.dao;

import org.prado.entity.ReceivingBookEntity;
import org.springframework.stereotype.Repository;

/**
 * @Author: houlintao
 * @Date:2020/7/4 下午3:57
 * @email 437547058@qq.com
 * @Version 1.0
 */
@Repository
public interface ReceivingBookDao extends BaseDao<ReceivingBookEntity> {
    @Override
    int save(ReceivingBookEntity receivingBookEntity);

    ReceivingBookEntity queryByDate(String date);

    @Override
    int update(ReceivingBookEntity entity);
}

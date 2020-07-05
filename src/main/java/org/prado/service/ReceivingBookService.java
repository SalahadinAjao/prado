package org.prado.service;

import org.prado.entity.ReceivingBookEntity;

/**
 * @Author: houlintao
 * @Date:2020/7/4 下午4:15
 * @email 437547058@qq.com
 * @Version 1.0
 */
public interface ReceivingBookService {

    void save(ReceivingBookEntity entity);

    ReceivingBookEntity queryByDate(String date);

    void update(ReceivingBookEntity bookEntity);
}

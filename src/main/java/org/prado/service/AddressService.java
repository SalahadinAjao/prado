package org.prado.service;

import org.prado.entity.AddressEntity;

import java.util.List;
import java.util.Map;

/**
 * @Author: houlintao
 * @Date:2020/7/2 下午1:23
 * @email 437547058@qq.com
 * @Version 1.0
 */
public interface AddressService {

    int save(AddressEntity entity);

    void update(AddressEntity entity);

    AddressEntity queryObject(Integer id);

    List<AddressEntity> queryList(Map<String,Object> map);

    int queryTotal(Map<String,Object> map);

    int queryTotal();

    void delete(Integer id);

    void deleteBatch(Integer[] ids);
}

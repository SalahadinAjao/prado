package org.prado.dao;

import org.prado.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * @Author: houlintao
 * @Date:2020/7/1 下午4:09
 * @email 437547058@qq.com
 * @Version 1.0
 */

@Repository
public interface UserDao {
     int save(UserEntity entity);
}

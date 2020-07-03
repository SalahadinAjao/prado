package org.prado.dao;

import org.apache.ibatis.annotations.Param;
import org.prado.entity.TokenEntity;
import org.springframework.stereotype.Repository;

/**
 * @Author: houlintao
 * @Date:2020/7/3 上午8:41
 * @email 437547058@qq.com
 * @Version 1.0
 */

@Repository
public interface TokenDao extends BaseDao<TokenEntity> {
    TokenEntity queryByUserId(long userId);

    TokenEntity queryByToken(@Param("token") String token);
}

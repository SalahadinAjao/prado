package org.prado.service;

import org.prado.entity.TokenEntity;

import java.util.Map;

/**
 * @Author: houlintao
 * @Date:2020/7/3 上午8:53
 * @email 437547058@qq.com
 * @Version 1.0
 */
public interface TokenService {

    void save(TokenEntity entity);

    Map<String,Object> createToken(long userId);

    TokenEntity queryByUserId(long userId);

    void update(TokenEntity entity);

    TokenEntity queryByToken(String token);
}

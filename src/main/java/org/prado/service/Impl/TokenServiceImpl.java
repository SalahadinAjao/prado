package org.prado.service.Impl;

import org.prado.dao.TokenDao;
import org.prado.entity.TokenEntity;
import org.prado.service.TokenService;
import org.prado.tools.CharTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: houlintao
 * @Date:2020/7/3 上午8:54
 * @email 437547058@qq.com
 * @Version 1.0
 */
@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    private TokenDao tokenDao;

    private final static Long EXPIRE = 3600 * 24 * 30L;

    @Override
    public void save(TokenEntity entity) {
        tokenDao.save(entity);
    }

    /**
     * 使用用户id创建token
     */

    @Transactional
    @Override
    public Map<String, Object> createToken(long userId) {
        //使用随机数生成一个token
        String token = CharTool.getRandomNumStr(32);
        Date nowDate = new Date();
        //设置token过期时间
        Date expireDate = new Date(nowDate.getTime() + EXPIRE * 1000);
        long timeLong = expireDate.getTime();

        TokenEntity tokenEntity = queryByUserId(userId);
       // System.out.printf("tokenEntity="+tokenEntity.getUserId());

        if (tokenEntity != null){
            System.out.println("tokenEntity != null");
            tokenEntity.setUpdateTime(nowDate);
            tokenEntity.setToken(token);
            tokenEntity.setExpireTime(expireDate);
            update(tokenEntity);
        } else {
            System.out.println("tokenEntity == null");
            tokenEntity = new TokenEntity();
            tokenEntity.setUserId(userId);
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(nowDate);
            tokenEntity.setExpireTime(expireDate);

            save(tokenEntity);
        }

        Date expire = new Date();
        expire.setTime(timeLong);
        SimpleDateFormat format = new SimpleDateFormat("yyyyy-MMMM-dddd hhhh:mmmm:ssss a E");
        String format1 = format.format(expire);

        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("token",tokenEntity);
        hashMap.put("expireTime",format1);
        return hashMap;
    }

    @Override
    public TokenEntity queryByUserId(long userId) {

       return tokenDao.queryByUserId(userId);
    }

    @Override
    public void update(TokenEntity entity) {
         tokenDao.update(entity);
    }
}

package org.prado.dao;

import org.prado.entity.UserVo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: houlintao
 * @Date:2020/7/1 下午4:09
 * @email 437547058@qq.com
 * @Version 1.0
 */

@Repository
public interface UserDao {
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout = 3)
    public int save(UserVo userVo);

    public int queryTotal();

    public UserVo queryByMobile(String mobile);
}

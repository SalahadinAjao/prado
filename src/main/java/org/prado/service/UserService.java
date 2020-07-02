package org.prado.service;

import org.prado.entity.UserVo;

/**
 * @Author: houlintao
 * @Date:2020/7/1 下午5:03
 * @email 437547058@qq.com
 * @Version 1.0
 */
public interface UserService {
    int save(UserVo userVo);

    int queryTotal();

    UserVo queryByMobile(String mobile);
}

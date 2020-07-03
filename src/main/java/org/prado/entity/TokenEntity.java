package org.prado.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: houlintao
 * @Date:2020/7/3 上午8:38
 * @email 437547058@qq.com
 * @Version 1.0
 */
public class TokenEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //用户ID
    private Long userId;
    //token
    private String token;
    //过期时间
    private Date expireTime;
    //更新时间
    private Date updateTime;

    public Long getUserId() {
        return userId;
    }

    public String getToken() {
        return token;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}

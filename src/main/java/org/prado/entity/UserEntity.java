package org.prado.entity;

import java.io.Serializable;

/**
 * @Author: houlintao
 * @Date:2020/7/1 下午5:00
 * @email 437547058@qq.com
 * @Version 1.0
 */
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String userName;

    private String passWord;

    private String teleNumber;

    private String estabTime;

    public void setEstabTime(String estabTime) {
        this.estabTime = estabTime;
    }

    public String getEstabTime() {
        return estabTime;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setTeleNumber(String teleNumber) {
        this.teleNumber = teleNumber;
    }

    public Integer getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getTeleNumber() {
        return teleNumber;
    }
}

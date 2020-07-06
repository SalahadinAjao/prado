package org.prado.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: houlintao
 * @Date:2020/7/6 上午10:44
 * @email 437547058@qq.com
 * @Version 1.0
 */
public class ChuLiRecordEntity implements Serializable {
    public static final long serialVersionUID = 1L;

    private long id;

    private long receivingbookentityId;

    private String chuliName;

    private BigDecimal chuliMoney;

    private String gift;

    private String chuliDate;

    public long getId() {
        return id;
    }

    public long getReceivingbookentityId() {
        return receivingbookentityId;
    }

    public String getChuliName() {
        return chuliName;
    }

    public BigDecimal getChuliMoney() {
        return chuliMoney;
    }

    public String getGift() {
        return gift;
    }

    public String getChuliDate() {
        return chuliDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setReceivingbookentityId(long receivingbookentityId) {
        this.receivingbookentityId = receivingbookentityId;
    }

    public void setChuliName(String chuliName) {
        this.chuliName = chuliName;
    }

    public void setChuliMoney(BigDecimal chuliMoney) {
        this.chuliMoney = chuliMoney;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }

    public void setChuliDate(String chuliDate) {
        this.chuliDate = chuliDate;
    }
}

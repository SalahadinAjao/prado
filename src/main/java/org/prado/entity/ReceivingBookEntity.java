package org.prado.entity;

import java.io.Serializable;

/**
 * @Author: houlintao
 * @Date:2020/7/4 下午3:40
 * @email 437547058@qq.com
 * @Version 1.0
 */
public class ReceivingBookEntity implements Serializable {

    public static final long serialVersionUID = 1L;

    private long id;

    private long userId;

    /**
     * 账本类别，默认为1
     * 1,结婚 2,生子 3,乔迁 4,入伍 5,升学 6,升迁 7,丧
     */
    private Integer type;
    //收礼簿的名称，方便日后查看，例如“周芷若与张无忌新婚礼簿” 这类的
    private String title;
    private String createDate;
    //修改日期
    private String updateDate;
    /**
     * 授权使用此账本记账的人的名字，即账本创建者可以将此账本授权给别人替他记收礼的账
     * 通过对应的二维码或者其他方式（如把替记账的人的名字输入），选填
     * 记账者记账前需要验证其 userId 是不是与账簿的创建者 userId一致，或者验证当前记账者的 userId
     * 是否出现
     * 后续使用shiro验证
     */
    private String recorder;

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public Integer getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public String getRecorder() {
        return recorder;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder;
    }
}

package org.prado.entity;

import java.io.Serializable;

/**
 * @Author: houlintao
 * @Date:2020/7/2 下午4:16
 * @email 437547058@qq.com
 * @Version 1.0
 */
public class UserLevelEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Integer id;
    //名称
    private String name;
    //描述
    private String description;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

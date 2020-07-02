package org.prado.common;

import org.apache.commons.lang.StringUtils;

/**
 * @Author: houlintao
 * @Date:2020/7/2 下午4:43
 * @email 437547058@qq.com
 * @Version 1.0
 * 数据校验类
 */
public abstract class Assert {
    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new RRException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new RRException(message);
        }
    }
}

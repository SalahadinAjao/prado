package org.prado.common;

import com.google.code.kaptcha.Producer;

import java.awt.image.BufferedImage;

/**
 * @Author: houlintao
 * @Date:2020/7/2 下午6:30
 * @email 437547058@qq.com
 * @Version 1.0
 */
public class KaptchaTool implements Producer{
    @Override
    public BufferedImage createImage(String text) {
        return null;
    }

    @Override
    public String createText() {
        return null;
    }
}

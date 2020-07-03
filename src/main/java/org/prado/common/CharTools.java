package org.prado.common;

import java.util.Random;

/**
 * @Author: houlintao
 * @Date:2020/7/3 上午9:18
 * @email 437547058@qq.com
 * @Version 1.0
 * 字符串工具类
 */
public class CharTools {

    public static String getRandomString(Integer num){
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();

        for (int i=0;i<num;i++){
            int anInt = random.nextInt(base.length());
            buffer.append(base.charAt(anInt));
        }
        return buffer.toString();
    }
}

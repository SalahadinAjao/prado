package org.prado.tools;

import java.util.Random;

/**
 * @Author: houlintao
 * @Date:2020/7/2 下午1:36
 * @email 437547058@qq.com
 * @Version 1.0
 */
public class CharTool {

    /**
     * 获取数字组成的随机字符串
     */
    public static String getRandomNumStr(Integer num){
        String base = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}

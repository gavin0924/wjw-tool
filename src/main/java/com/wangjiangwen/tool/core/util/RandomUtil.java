package com.wangjiangwen.tool.core.util;

import java.util.Random;

/**
 * @author wjw
 * @since 2021/5/24 13:48
 **/
public class RandomUtil {
    /**
     * 生成指定长度的随机字符串，包含a-zA-Z0-9
     *
     * @param length 指定长度
     * @return 目标字符串
     */
    public static String randomStr(int length) {
        if (length <= 0) {
            throw new RuntimeException("请填写大于0的参数");
        }
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(str.length());
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 生成指定范围内的随机数
     *
     * @param min 最小值
     * @param max 最大值(不包含)
     * @return 随机数
     */
    public static int randomInt(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }

}

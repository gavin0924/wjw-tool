package com.wangjiangwen.tool.core.util;

import com.wangjiangwen.tool.core.bean.SnowFlake;

import java.util.UUID;

/**
 * @author Gavin
 * @since 2023/2/7 13:47
 */
public class IdUtil {
    /**
     * 生成UUID
     *
     * @return UUID
     */
    public static String UUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * 生成去掉“-”的UUID
     *
     * @return simpleUUID
     */
    public static String simpleUUID() {
        return UUID().replace("-", "");
    }

    /**
     * 创建新SnowFlake对象
     *
     * @return 结果
     */
    public static SnowFlake createSnowFlake(long workerId) {
        return new SnowFlake(workerId);
    }
}

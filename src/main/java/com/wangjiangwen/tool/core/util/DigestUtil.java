package com.wangjiangwen.tool.core.util;

import org.springframework.util.DigestUtils;

/**
 * @author wjw
 * @since 2021/1/10 21:21
 **/
public class DigestUtil {
    /**
     * 密码加密
     *
     * @param oldPassword 原密码
     * @param salt        盐值
     * @return 新密码
     */
    public static String encrypt(String oldPassword, String salt) {
        String password = oldPassword;
        for (int i = 0; i < 5; i++) {
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes());
        }
        return password;
    }

    /**
     * 验证密码是否不匹配
     *
     * @param password        加密之前的密码
     * @param salt            盐值
     * @param encryptPassword 真实密码
     * @return 是否不匹配
     */
    public static boolean unMatched(String password, String salt, String encryptPassword) {
        return !encryptPassword.equals(encrypt(password, salt));
    }

}

package com.wangjiangwen.tool.core.util;


import com.wangjiangwen.tool.core.exceptions.WjwException;

/**
 * @author wjw
 * @since 2021/5/24 13:48
 **/
public class StrUtil {
    public static final String SPACE = " ";
    public static final String TAB = "\t";
    public static final String DOT = ".";
    public static final String DOUBLE_DOT = "..";
    public static final String SLASH = "/";
    public static final String BACKSLASH = "\\";
    public static final String EMPTY = "";
    public static final String NULL = "null";
    public static final String CR = "\r";
    public static final String LF = "\n";
    public static final String CRLF = "\r\n";
    public static final String UNDERLINE = "_";
    public static final String DASHED = "-";
    public static final String COMMA = ",";
    public static final String DELIM_START = "{";
    public static final String DELIM_END = "}";
    public static final String BRACKET_START = "[";
    public static final String BRACKET_END = "]";
    public static final String COLON = ":";
    public static final String LT = "&lt;";
    public static final String GT = "&gt;";
    public static final String HTTP = "http://";
    public static final String HTTPS = "https://";


    /**
     * 例：
     * StrUtil.isEmpty(null) // true
     * StrUtil.isEmpty("") // true
     * StrUtil.isEmpty("abc") // false
     *
     * @param str 目标字符串
     * @return 是否为空
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    /**
     * 例：
     * StrUtil.isEmpty(null) // false
     * StrUtil.isEmpty("") // false
     * StrUtil.isEmpty("abc") // true
     *
     * @param str 目标字符串
     * @return 是否非空
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 截取字符串,支持负号(即倒数),会处理越界问题以及防止位置相反
     *
     * @param str   目标字符串
     * @param start 开始位置
     * @param end   结束位置
     * @return 截取之后的字符串
     */
    public static String sub(String str, Integer start, Integer end) {
        if (start < 0) {
            start = str.length() + start;

        }
        if (start < 0 || start >= str.length()) {
            start = 0;
        }
        if (end <= 0) {
            end = str.length() + end;

        }
        if (end <= 0 || end >= str.length()) {
            end = str.length();
        }
        if (start > end) {
            start = start ^ end;
            end = start ^ end;
            start = start ^ end;
        }
        return str.substring(start, end);
    }

    public static String removePrefix(String str, String prefix) {
        if (!str.startsWith(prefix)) {
            throw new WjwException(str + "不是以" + prefix + "开头的");
        }
        return str.substring(prefix.length());
    }

    public static String removeSuffix(String str, String suffix) {
        if (!str.endsWith(suffix)) {
            throw new WjwException(str + "不是以" + suffix + "结尾的");
        }
        return str.substring(0, str.length() - suffix.length());
    }

    public static String format(String... strings) {
        String placeholder = "{}";
        for (int i = 1; i < strings.length; i++) {
            strings[0] = replace(strings[0], placeholder, strings[i]);
        }
        return strings[0];
    }

    public static String replace(String str, String oldStr, String replaceStr) {
        int index = str.indexOf(oldStr);
        if (index != -1) {
            str = str.substring(0, index) + replaceStr + str.substring(index + oldStr.length());
        }
        return str;
    }

    public static String replaceAll(String str, String oldStr, String replaceStr) {
        if (replaceStr.contains(oldStr)) {
            throw new WjwException("替换字符不能包含被替换字符");
        }
        while (true) {
            int index = str.indexOf(oldStr);
            if (index != -1) {
                str = str.substring(0, index) + replaceStr + str.substring(index + oldStr.length());
            } else {
                return str;
            }
        }
    }
}

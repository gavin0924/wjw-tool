package com.wangjiangwen.tool.core.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author wjw
 * @since 2021/5/24 13:48
 **/
public class ListUtil {

    /**
     * 通过连接符转化为string
     *
     * @param list      被转化对象
     * @param jointChar 连接符
     * @return 结果
     */
    public static String listToString(List<?> list, String jointChar) {
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(list.get(i));
            if (i != list.size() - 1) {
                stringBuilder.append(jointChar);
            }
        }
        return stringBuilder.toString();
    }

    public static List<String> stringToList(String source, String jointChar) {
        if (StrUtil.isEmpty(source)) {
            return new ArrayList<>();
        }
        return new ArrayList<>(Arrays.asList(source.split(jointChar)));
    }

    /**
     * 去重
     */
    public static <T> List<T> distinct(List<T> list) {
        HashSet<T> set = new HashSet<>(list);
        list.clear();
        list.addAll(set);
        return list;
    }

    public static <S,T> List<T> copy(List<S> source, Class<T> target){
        List<T> ts = new ArrayList<>();
        for (S s : source) {
            T t = ObjUtil.copy(s, target);
            ts.add(t);
        }
        return ts;
    }
}

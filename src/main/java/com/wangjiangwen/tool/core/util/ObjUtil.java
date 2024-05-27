package com.wangjiangwen.tool.core.util;


import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.core.Converter;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author Gavin
 * @since 2021/7/19 15:14
 **/
public class ObjUtil {

    public static <S, T> T copy(S source, Class<T> target) {
        return copy(source, target, null);
    }

    public static <S, T> T copy(S source, Class<T> target, Converter converter) {
        BeanCopier beanCopier = BeanCopierCache.get(source.getClass(), target, converter != null);
        try {
            T t = target.getDeclaredConstructor().newInstance();
            beanCopier.copy(source, t, converter);
            return t;
        } catch (Exception e) {
            throw new RuntimeException("copy出错");
        }
    }


}

class BeanCopierCache {
    private final static Map<String, BeanCopier> cache = new WeakHashMap<>();

    public static BeanCopier get(Class<?> source, Class<?> target, boolean useConverter) {
        String key = source.getName() + "#" + target.getName() + "#" + (useConverter ? "1" : "0");
        return cache.computeIfAbsent(key, (s) -> BeanCopier.create(source, target, useConverter));
    }
}
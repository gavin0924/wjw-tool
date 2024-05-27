package com.wangjiangwen.tool.core.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gavin
 * @since 2021/8/11
 */
public class Dict<K, V> extends HashMap<K, V> {
    public static <K, V> Dict<K, V> create() {
        return new Dict<K, V>();
    }

    public static <K, V> Dict<K, V> create(Map<K, V> map) {
        Dict<K, V> dict = new Dict();
        for (K key : map.keySet()) {
            dict.put(key, map.get(key));
        }
        return dict;
    }

    public Dict<K, V> set(K key, V value) {
        this.put(key, value);
        return this;
    }

    public Long getLong(String key) {
        return (Long) this.get(key);
    }

    public Integer getInt(String key) {
        return (Integer) this.get(key);
    }

    public Short getShort(String key) {
        return (Short) this.get(key);
    }

    public Byte getByte(String key) {
        return (Byte) this.get(key);
    }

    public Character getChar(String key) {
        return (Character) this.get(key);
    }

    public Boolean getBool(String key) {
        return (Boolean) this.get(key);
    }

    public Double getDouble(String key) {
        return (Double) this.get(key);
    }

    public Float getFloat(String key) {
        return (Float) this.get(key);
    }

    public String getString(String key) {
        return (String) this.get(key);
    }

    public Date getDate(String key) {
        return (Date) this.get(key);
    }

    public BigDecimal getBigDecimal(String key) {
        return (BigDecimal) this.get(key);
    }

    public BigInteger getBigInteger(String key) {
        return (BigInteger) this.get(key);
    }

    public Byte[] getBytes(String key) {
        return (Byte[]) this.get(key);
    }
}

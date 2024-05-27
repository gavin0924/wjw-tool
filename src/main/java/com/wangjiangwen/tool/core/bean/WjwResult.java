package com.wangjiangwen.tool.core.bean;


import java.util.HashMap;

public class WjwResult extends HashMap<String, Object> {
    public static final Integer CODE_SUCCESS = 200;
    public static final Integer CODE_ERROR = 500;

    public WjwResult(Integer code, String message, Object data) {
        this.put("code", code);
        this.put("message", message);
        this.put("data", data);
    }

    public static WjwResult ok() {
        return new WjwResult(CODE_SUCCESS, "ok", null);
    }

    public static WjwResult ok(Object data) {
        return new WjwResult(CODE_SUCCESS, "ok", data);
    }

    public static WjwResult ok(String message) {
        return new WjwResult(CODE_SUCCESS, message, null);
    }

    public static WjwResult fail(String message) {
        return new WjwResult(CODE_ERROR, message, null);
    }

    public static WjwResult get(Integer code, String message) {
        return new WjwResult(code, message, null);
    }
}
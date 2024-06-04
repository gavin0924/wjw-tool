package com.wangjiangwen.tool.core.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class R<T> {
    public static final Integer CODE_SUCCESS = 200;
    public static final Integer CODE_ERROR = 500;

    private Integer code;
    private String message;
    private T data;

    public static <T> R<T> ok() {
        return new R<>(CODE_SUCCESS, "ok", null);
    }

    public static <T> R<T> ok(T data) {
        return new R<>(CODE_SUCCESS, "ok", data);
    }

    public static <T> R<T> ok(String message) {
        return new R<>(CODE_SUCCESS, message, null);
    }

    public static <T> R<T> fail(String message) {
        return new R<>(CODE_ERROR, message, null);
    }

    public static <T> R<T> get(Integer code, String message) {
        return new R<>(code, message, null);
    }

}
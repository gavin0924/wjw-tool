package com.wangjiangwen.tool.core.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.ArrayList;
import java.util.List;

public class PageUtil {
    public static <S,T> Page<T> copy(List<S> source, Class<T> target){
        Page<T> tPage = ObjUtil.copy(source, Page.class);
        List<T> ts = new ArrayList<>();
        for (S s : source) {
            T t = ObjUtil.copy(s, target);
            ts.add(t);
        }
        tPage.setRecords(ts);
        return tPage;
    }
}

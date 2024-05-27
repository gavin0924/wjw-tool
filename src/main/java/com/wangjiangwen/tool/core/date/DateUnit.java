package com.wangjiangwen.tool.core.date;

import java.util.Calendar;

/**
 * @author gavin
 * @since 2021/8/9
 */
public enum DateUnit {
    MILLISECOND(1),
    SECOND(1000),
    MINUTE(SECOND.getMillis() * 60),
    HOUR(MINUTE.getMillis() * 60),
    DAY(HOUR.getMillis() * 24),
    WEEK(DAY.getMillis() * 7);

    private final int millis;

    DateUnit(int millis) {
        this.millis = millis;
    }

    public int getMillis() {
        return this.millis;
    }

}

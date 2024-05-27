package com.wangjiangwen.tool.core.util;

import com.wangjiangwen.tool.core.date.DateField;
import com.wangjiangwen.tool.core.date.DateUnit;
import com.wangjiangwen.tool.core.date.SystemClock;
import com.wangjiangwen.tool.core.exceptions.WjwException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    /**
     * 获取当前时间
     *
     * @return date
     */
    public static Date date() {
        return new Date(SystemClock.now());
    }

    /**
     * 获取指定时间戳的时间
     *
     * @return date
     */
    public static Date date(long timestamp) {
        return new Date(timestamp);
    }

    /**
     * 字符串转为时间
     *
     * @param dateStr 时间字符川
     * @return 时间
     */
    public static Date toDate(String dateStr) {
        return toDate(dateStr, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 字符串转为时间
     *
     * @param dateStr 时间字符川
     * @param format  转换格式
     * @return 时间
     */
    public static Date toDate(String dateStr, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date parseDate;
        try {
            parseDate = sdf.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException("时间转换异常");
        }
        return parseDate;
    }

    /**
     * 时间转为字符串
     *
     * @param date 时间
     * @return 字符串
     */
    public static String toString(Date date) {
        return DateTimeFormatterHolder.dateTimeFormatter.format(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()));
    }

    private static final class DateTimeFormatterHolder {
        private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }
    /**
     * 时间转为字符串
     *
     * @param date   时间
     * @param format 格式
     * @return 字符串
     */
    public static String toString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 获取指定时间的当天开始时间
     *
     * @param date 指定时间
     * @return 当天开始时间
     */
    public static Date beginOfDay(Date date) {
        Calendar beginOfDay = Calendar.getInstance();
        beginOfDay.setTime(date);
        beginOfDay.set(Calendar.HOUR_OF_DAY, 0);
        beginOfDay.set(Calendar.MINUTE, 0);
        beginOfDay.set(Calendar.SECOND, 0);
        beginOfDay.set(Calendar.MILLISECOND, 0);
        return beginOfDay.getTime();
    }

    /**
     * 获取指定时间的当月开始时间
     *
     * @param date 指定时间
     * @return 当月开始时间
     */
    public static Date beginOfMonth(Date date) {
        Calendar beginOfMonth = Calendar.getInstance();
        beginOfMonth.setTime(date);
        beginOfMonth.set(Calendar.DAY_OF_MONTH, 1);
        beginOfMonth.set(Calendar.HOUR_OF_DAY, 0);
        beginOfMonth.set(Calendar.MINUTE, 0);
        beginOfMonth.set(Calendar.SECOND, 0);
        beginOfMonth.set(Calendar.MILLISECOND, 0);
        return beginOfMonth.getTime();
    }

    /**
     * 获取指定时间的当年开始时间
     *
     * @param date 指定时间
     * @return 当年开始时间
     */
    public static Date beginOfYear(Date date) {
        Calendar beginOfYear = Calendar.getInstance();
        beginOfYear.setTime(date);
        beginOfYear.set(Calendar.MONTH, 0);
        beginOfYear.set(Calendar.DAY_OF_MONTH, 1);
        beginOfYear.set(Calendar.HOUR_OF_DAY, 0);
        beginOfYear.set(Calendar.MINUTE, 0);
        beginOfYear.set(Calendar.SECOND, 0);
        beginOfYear.set(Calendar.MILLISECOND, 0);
        return beginOfYear.getTime();
    }

    /**
     * 获取指定时间的当天结束时间
     *
     * @param date 指定时间
     * @return 当天结束时间
     */
    public static Date endOfDay(Date date) {
        Calendar endOfDay = Calendar.getInstance();
        endOfDay.setTime(beginOfDay(date));
        endOfDay.add(Calendar.DAY_OF_MONTH, 1);
        endOfDay.add(Calendar.MILLISECOND, -1);
        return endOfDay.getTime();
    }

    /**
     * 获取指定时间的当月结束时间
     *
     * @param date 指定时间
     * @return 当月结束时间
     */
    public static Date endOfMonth(Date date) {
        Calendar endOfMonth = Calendar.getInstance();
        endOfMonth.setTime(beginOfMonth(date));
        endOfMonth.add(Calendar.MONTH, 1);
        endOfMonth.add(Calendar.MILLISECOND, -1);
        return endOfMonth.getTime();
    }

    /**
     * 获取指定时间的当年结束时间
     *
     * @param date 指定时间
     * @return 当年结束时间
     */
    public static Date endOfYear(Date date) {
        Calendar endOfYear = Calendar.getInstance();
        endOfYear.setTime(beginOfYear(date));
        endOfYear.add(Calendar.YEAR, 1);
        endOfYear.add(Calendar.MILLISECOND, -1);
        return endOfYear.getTime();
    }

    /**
     * 获取指定时间的年
     *
     * @param date 指定时间
     * @return 年
     */
    public static int year(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取指定时间的月,并非以0开始的月
     *
     * @param date 指定时间
     * @return 月
     */
    public static int month(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取指定时间的日
     *
     * @param date 指定时间
     * @return 日
     */
    public static int day(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 昨天
     *
     * @return 昨天
     */
    public static Date yesterday() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return calendar.getTime();
    }

    /**
     * 明天
     *
     * @return 明天
     */
    public static Date tomorrow() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 上周
     *
     * @return 上周
     */
    public static Date lastWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.WEEK_OF_MONTH, -1);
        return calendar.getTime();
    }

    /**
     * 下周
     *
     * @return 下周
     */
    public static Date nextWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.WEEK_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 上个月
     *
     * @return 上个月
     */
    public static Date lastMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        return calendar.getTime();
    }

    /**
     * 下个月
     *
     * @return 下个月
     */
    public static Date nextMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 增减日期
     * @param date 基准日期
     * @param dateField 偏移的粒度大小
     * @param offset 偏移量，正数为向后偏移，负数为向前偏移
     * @return 偏移后的日期
     */
    public static Date offset(Date date, DateField dateField, int offset) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(dateField.getValue(), offset);
        return calendar.getTime();
    }

    public static long between(Date startDate, Date endDate, DateUnit dateUnit) {
        long startTime = startDate.getTime();
        long endTime = endDate.getTime();
        long between = Math.abs(endTime - startTime);
        return between / dateUnit.getMillis();
    }

    public static int compare(Date date1, Date date2) {
        if (date1.getTime() - date2.getTime() > 0) {
            return 1;
        }
        if (date1.getTime() - date2.getTime() < 0) {
            return -1;
        }
        return 0;
    }

    public static Boolean gt(Date date1, Date date2) {
        return date1.getTime() > date2.getTime();
    }

    public static Boolean ge(Date date1, Date date2) {
        return date1.getTime() >= date2.getTime();
    }

    public static Boolean lt(Date date1, Date date2) {
        return date1.getTime() < date2.getTime();
    }

    public static Boolean le(Date date1, Date date2) {
        return date1.getTime() <= date2.getTime();
    }
}

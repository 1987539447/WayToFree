package com.github.siemen.jdk8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by Zhan on 2017/2/28 0028.
 * JDK8新的日期时间处理
 * LocalDate 对应日期-年月日
 * LocalTime 对应时间-时分秒纳秒
 * LocalDateTime - 对应年月日时分秒纳秒
 */
public class JDK8DateTime {

    public static void main(String[] args) {

        //当前日期
        LocalDate today = LocalDate.now();
        System.out.println("today----"+today);
        //根据参数创建日期 - 自动正确性检查
        LocalDate day1 = LocalDate.of(2017,02,28);
        System.out.println("day1--"+day1);
        //解析日期 - 自动正确性检查
        LocalDate day2 = LocalDate.parse("2017-02-28");
        System.out.println("day2---"+day2);

        //本月第一天
        LocalDate firstDayOfThisMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("firstDayOfThisMonth---------"+firstDayOfThisMonth);
        LocalDate firstDayOfThisYear = today.with(TemporalAdjusters.firstDayOfYear());
        System.out.println("firstDayOfThisMonth---------"+firstDayOfThisYear);
        LocalDate firstDayOfNextYear = today.with(TemporalAdjusters.firstDayOfNextYear());
        System.out.println("firstDayOfThisMonth---------"+firstDayOfNextYear);

        //本月第X天
        LocalDate nDayOfThisMonth = today.withDayOfMonth(28);
        System.out.println("nDayOfThisMonth----------"+nDayOfThisMonth);
        //本月最后一天
        LocalDate lastDayOfThisMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("lastDayOfThisMonth----------"+lastDayOfThisMonth);
        //下一天
        LocalDate nexDay = lastDayOfThisMonth.plusDays(1);
        System.out.println("nexDay----------"+nexDay);
        //下一月
        LocalDate dayOfNextMonth = lastDayOfThisMonth.plusMonths(1);
        System.out.println("dayOfNextMonth----------"+dayOfNextMonth);
        //下一个月-超过天数
        LocalDate extDayOfNextMonth = LocalDate.parse("2017-03-31").plusMonths(1);
        System.out.println("extDayOfNextMonth----------"+extDayOfNextMonth);
        //本月第一个周一
        LocalDate firstMondayOfThisMont = today.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println("firstMondayOfThisMont----------"+firstMondayOfThisMont);

        //当前时间
        LocalTime now = LocalTime.now();
        System.out.println("now--------"+now);

        //当前时间
        LocalTime nowNoNano = LocalTime.now().withNano(0);
        System.out.println("nowNoNano--------"+nowNoNano);
        //构造时间
        LocalTime zero = LocalTime.of(0,0,0);
        LocalTime mid = LocalTime.parse("12:01:01");
        System.out.println("zero---"+zero+"---mid---"+mid);

        //当前日期时间
        LocalDateTime dayNow = LocalDateTime.now();
        System.out.println("dayNow----"+dayNow);
        dayNow = LocalDateTime.of(LocalDate.now(),LocalTime.now());
        String formated = DateTimeFormatter.ofPattern("yyyy-mm-dd HH:MM:SS").format(dayNow);
        System.out.println("formated----"+formated);
        //亚洲时区
        LocalDateTime asiaNow = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("asiaNow----"+asiaNow);
        Instant convInstant = asiaNow.toInstant(ZoneOffset.UTC);
        System.out.println("convInstant----"+convInstant);

        //绝对时间点 格林威治时间（GMT）1970-01-01:00:00
        Instant instant = Instant.now();
        System.out.println(instant);

    }
}

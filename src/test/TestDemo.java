package test;

import org.testng.annotations.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Date;
import java.util.Objects;

/**
 * @projectName: leetcode
 * @package: test
 * @className: Test
 * @author: Sveinn
 * @description: TODO
 * @date: 2022/12/19 13:38
 * @version: 1.0
 */
public class TestDemo {
    @Test
    public void test(){
        boolean[]  arr=new boolean[5];
        for (boolean b : arr) {
            System.out.println(b);
        }
    }
    @Test
    public static void testTime(){
        WeekFields weekFields = WeekFields.ISO;
        LocalDate now = LocalDate.now();
        LocalDate localDate = now.withYear(2023).with(weekFields.weekOfYear(),
                1);
        System.out.println(localDate);
        LocalDate goalLocalDate = localDate.with(weekFields.dayOfWeek(),
                1);
        System.out.println(goalLocalDate);
        System.out.println(LocalDate.now().minusWeeks(0));
        String weekDateOfDay = getWeekDateOfDay(convertDate(goalLocalDate, "yyyy-MM-dd"));
        String s = convertDate(goalLocalDate, "yyyy-MM-dd");
        System.out.println(weekDateOfDay);
        System.out.println(s);
        LocalDate of = LocalDate.of(Integer.parseInt(s.substring(0, 4)),
                Integer.parseInt(s.substring(5, 7)),
                Integer.parseInt(s.substring(8, 10)));
        System.out.println(of);
        LocalDateTime localDateTime = of.atTime(0, 0, 0);
        System.out.println(localDateTime);
        Date date = localDateTimeToDate(localDateTime);
        System.out.println(date);

    }
    public static String getWeekDateOfDay(String date) {
        LocalDate localDate = LocalDate.parse(date);
        int year = localDate.get(WeekFields.ISO.weekBasedYear());
        int week = localDate.get(WeekFields.ISO.weekOfWeekBasedYear());
        String weekDate = week >= 10 ? year + "" + week : year + "0" + week;
        return weekDate;
    }
    public static String convertDate(LocalDate date, String pattern) {
        if (Objects.isNull(date)) {
            return "";
        }
        DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern);
        return df.format(date);
    }
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }
    @Test
    public void testBigDecimal(){
//        BigDecimal divide = new BigDecimal(30).divide(new BigDecimal(0), 2, BigDecimal.ROUND_DOWN);
        int i = Integer.parseInt("01");
//        System.out.println(divide);
        System.out.println(i);
    }


}


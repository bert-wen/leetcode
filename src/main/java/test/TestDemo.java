package test;

import org.testng.annotations.Test;
import sun.reflect.generics.tree.VoidDescriptor;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    @Test
    public void testDemo(){
        System.out.println(14^3);
    }
    @Test
    public void testContains(){
        List<Long> list=new ArrayList<>();
        for (long i=0;i<30000;i++){
            list.add(i);
        }
        List<Long> value=new ArrayList<>();
        for (long i=1;i<20000;i++){
            value.add(i);
        }
        List<Long> resList=new ArrayList<>();
        long l = System.currentTimeMillis();
        for (int i = 0; i < value.size(); i++) {
            if(!list.contains(value.get(i))){
                resList.add(value.get(i));
            }
        }
//        long l1 = System.currentTimeMillis();
        System.out.println(resList.size());
//
        long l2 = System.currentTimeMillis();
        List<Long> collect = list.stream().filter(t -> !value.contains(t)).collect(Collectors.toList());
        long l3 = System.currentTimeMillis();
//
//
//        long start = System.currentTimeMillis();
//        list.removeAll(value);
//        long end = System.currentTimeMillis();
//        System.out.println("removeAll所花费的时间:"+(end-start));
        System.out.println("stream所花费时间："+(l3-l2));
//        System.out.println("contains所花费的时间："+(l1-l));
//        System.out.println(resList);
        long l4 = System.currentTimeMillis();
        CopyOnWriteArrayList<Long> longs = filterList(list, value);
        long l5 = System.currentTimeMillis();
        System.out.println("filterList花费时间:"+(l5-l4));
        System.out.println(list.size());
        System.out.println(longs.size());
        System.out.println(collect.size());

    }
    public void testString(){
        String str="hello word";
        str+='a';
        str=str+100;
    }
    @Test
    public void testFilterList(){
        List<Student> list=new ArrayList<>();
        for (int i=0;i<100000;i++){
            list.add(new Student(i,"张三"+i));
        }
        List<Student> filterList=new ArrayList<>();
        for (int j=1;j<100;j++){
            list.add(new Student(j*10,"张三"+j*10));
        }
//        CopyOnWriteArrayList<Student> students = filterList(list, filterList);
//        System.out.println(students);
    }

    public static CopyOnWriteArrayList<Long> filterList(List<Long> list, List<Long> filterList){
        ConcurrentHashMap<Long,Long> filterMap = new ConcurrentHashMap<>();
        filterList.parallelStream().map(id->filterMap.put(id,id));
//
//        return list.parallelStream().filter(id -> {
//            Long idT = filterMap.get(id);
//            return Objects.isNull(idT);
//        }).collect(Collectors.toCollection(CopyOnWriteArrayList::new));
//        return list.parallelStream().map(filterMap::get).filter(Objects::isNull)
//                .collect(Collectors.toCollection(CopyOnWriteArrayList::new));
        CopyOnWriteArrayList<Long> subjectIds= new CopyOnWriteArrayList<>();
        list.parallelStream().forEach(id->{
            Long aLong = filterMap.get(id);
            if (Objects.isNull(aLong)){
                subjectIds.add(aLong);
            }
        });
        return subjectIds;
    }


}


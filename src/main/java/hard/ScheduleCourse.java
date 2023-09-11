package hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *  课程表3
 *  贪心 + 优先队列（堆）
 */
public class ScheduleCourse {
    public static void main(String[] args) {
        int [][] courses = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
        scheduleCourse(courses);
        for (int[] cours : courses) {
            System.out.println(cours[0]+"-"+cours[1]);
        }
    }
    public static int scheduleCourse(int[][] courses) {
        int sum=0;
        // 根据上课终止时间排序
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b)->b-a);
        // 结束时间最短的先选，如果结束时间先选都不能选上，那么这么课就选不上
        for (int[] cours : courses) {
            int duration=cours[0];
            int lastDay=cours[1];
            sum+=duration;
            q.add(duration);
            if (sum>lastDay){
                sum-=q.poll();
            }
        }
        return q.size();
    }


}

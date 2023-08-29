package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: medium
 * @className: MergeInterval
 * @author: WenHui
 * @description: 合并区间
 * @date: 2023/8/27 20:10
 * @version: 1.0
 */
public class InsertInterval {
    public static void main(String[] args) {
        // {{1,2},{3,5},{6,7},{8,10},{12,16}}
        //
        int[][] intervals = {{1,5}};
        int[] newInterval={0,3};
        int[][] insert = insert(intervals, newInterval);
        for (int[] ints : insert) {
            System.out.println(Arrays.toString(ints));
        }
    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] { newInterval };
        }
        int[][] newArr = addNumber(intervals, newInterval[0], newInterval[1]);
        Arrays.sort(newArr, (interval1, interval2) -> interval1[0] - interval2[0]);
        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = newArr[0];
        for (int i = 1; i < newArr.length; i++) {
            if (newArr[i][0]<=currentInterval[1] && newArr[i][0]>=currentInterval[0]){
                currentInterval[1]=Math.max(currentInterval[1],newArr[i][1]);
            }else {
                merged.add(currentInterval);
                currentInterval=newArr[i];
            }
        }
        merged.add(currentInterval);
        return merged.toArray(new int[merged.size()][]);
    }
    public static int[][] addNumber(int[][] intervals,int num1,int num2){
        int [][] arr=new int[intervals.length+1][2];
        for (int i = 0; i < arr.length; i++) {
            if (i==intervals.length){
                arr[i][0]=num1;
                arr[i][1]=num2;
            }else {
                arr[i][0]=intervals[i][0];
                arr[i][1]=intervals[i][1];
            }
        }
        return arr;
    }
}

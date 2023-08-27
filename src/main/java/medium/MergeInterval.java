package medium;

import java.util.ArrayList;
import java.util.Arrays;
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
public class MergeInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{0,0}};
        int[][] merge = merge(intervals);
        for (int[] ints : merge) {
            System.out.println(ints[0] + " " + ints[1]);
        }
    }
    public static int[][] merge(int[][] intervals) {
        if (intervals.length<=1){
            return intervals;
        }
        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
           if (intervals[i][0]<=currentInterval[1] && intervals[i][0]>=currentInterval[0]){
               currentInterval[0]=Math.min(currentInterval[0],intervals[i][0]);
               currentInterval[1]=Math.max(currentInterval[1],intervals[i][1]);
           }else {
               merged.add(currentInterval);
               currentInterval=intervals[i];
           }
        }
        merged.add(currentInterval);
        return merged.toArray(new int[merged.size()][]);
    }
}

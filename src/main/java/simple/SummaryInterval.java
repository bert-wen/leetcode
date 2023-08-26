package simple;

import jdk.internal.org.objectweb.asm.tree.analysis.SourceInterpreter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: simple
 * @className: SummaryInterval
 * @author: WenHui
 * @description:  汇总区间
 * @date: 2023/8/26 20:03
 * @version: 1.0
 */
public class SummaryInterval {
    public static void main(String[] args) {
        int [] nums={-1};
        List<String> strings = summaryInterval(nums);
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println("=========");
        List<String> strings1 = optimizeRanges(nums);
        System.out.println(strings1);
    }
    public static List<String> summaryInterval(int []nums){
        ArrayList<String> list = new ArrayList<>();
        // 空数组处理
        if (nums.length==0){
            return list;
        }
        int start=nums[0];
        for (int i=1;i<=nums.length;i++) {
            // i==nums.length是为了解决数组中只有一个数的情况
           if (i==nums.length ||nums[i]-nums[i-1]>1){
               if (nums[i-1]==start){
                   list.add(start+"");
               }else {
                   list.add(start+"->"+nums[i-1]);
               }
               if (i<nums.length){
                   start=nums[i];
               }
           }
        }
        return list;
    }
    public static List<String> optimizeRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        // 空数组处理
        if (nums.length==0){
            return list;
        }
        int start = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length || nums[i] > nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    list.add(String.valueOf(start));
                } else {
                    list.add(start + "->" + nums[i - 1]);
                }
                if (i < nums.length) {
                    start = nums[i];
                }
            }
        }

        return list;
    }







}

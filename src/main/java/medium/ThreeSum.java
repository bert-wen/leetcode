package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: medium
 * @className: ThreeSum
 * @author: Sveinn
 * @description: 三数之和(排序+双指针）排序是为了降重，双指针是为了降低时间复杂度
 * @date: 2023/1/4 13:16
 * @version: 1.0
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums={-1,0,1,2,-1,-4,-2,-3,3,0,4};
        List<List<Integer>> listList = threeSum(nums);
        System.out.println(listList);
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listList=new ArrayList<>();
        Arrays.sort(nums);
        for (int first = 0; first < nums.length; first++) {
            int third=nums.length-1;
            //避免第一个数重复的情况
            if (first>0 && nums[first]==nums[first-1]){
                continue;
            }
            for (int second=first+1;second<nums.length;second++){
                //避免第二个数重复的情况
                if (second>first+1 && nums[second]==nums[second-1]){
                    continue;
                }
                //如果加起来不为0就一直往左移动
                while(third>second && nums[third]+nums[first]+nums[second]>0 ){
                    third--;
                }
                //如果最右的指针和第二个指针相等则退出循环
                if (third==second){
                    break;
                }
                //如果是相等添加到集合中
                if (nums[third]+nums[first]+nums[second]==0){
                    List<Integer> list =new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    listList.add(list);
                }
            }
        }
        return listList;
    }
}

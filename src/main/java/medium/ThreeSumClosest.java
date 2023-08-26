package medium;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: medium
 * @className: ThreeSumClosest
 * @author: WenHui
 * @description: 三数之和相加最接近目标数字
 * @date: 2023/1/6 12:18
 * @version: 1.0
 */
public class ThreeSumClosest {
    public static void main(String[] args) {

        int[] nums={4,0,5,-5,3,3,0,-4,-5};
        int i = threeSumClosest(nums, -2);
        System.out.println(i);
        int i1 = threeSumClosestOptimize(nums, -2);
        System.out.println(i1);
    }

 /**
  * @param nums:
  * @param target:
  * @return int
  * @author WenHui
  * @description 双指针
  * @date 2023/1/6 13:20
  */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ant=nums[0]+nums[1]+nums[2];
        for (int first = 0; first < nums.length; first++) {
            if (first>1 && nums[first]==nums[first-1]){
                continue;
            }
            for (int second=first+1;second<nums.length;second++ ){
                if (second>first+1 && nums[second]==nums[second-1]){
                    continue;
                }
                int third=nums.length-1;
                while (third>second){
                    int sum=nums[first]+nums[second]+nums[third];
                    if (Math.abs(ant-target)>Math.abs(sum-target)){
                        ant=sum;
                    }
                    if (ant==target){
                        return ant;
                    }
                    third--;
                }
            }
        }
        return ant;
    }
    /**
     * @param nums:
     * @param target:
     * @return int
     * @author WenHui
     * @description 少用一层循环
     * @date 2023/1/6 13:37
     */
    public static int threeSumClosestOptimize(int[] nums, int target) {
        Arrays.sort(nums);
        int ans=nums[0]+nums[1]+nums[2];
        for (int first=0;first<nums.length;first++){
            int second=first+1;
            int third=nums.length-1;
            while (third>second){
                int sum=nums[first]+nums[second]+nums[third];
                if(Math.abs(ans-target)>Math.abs(sum-target)){
                    ans=sum;
                }

                if (sum>target){
                    third--;
                }else if(sum<target){
                    second++;
                }else {
                    return ans;
                }
            }
        }
        return ans;
    }
}

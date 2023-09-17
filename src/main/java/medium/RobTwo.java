package medium;

import java.util.Arrays;

/**
 * 打家劫舍 II(动态规划)
 */
public class RobTwo {
    public static void main(String[] args) {
        int []nums={2,3,2};
        int rob = rob(nums);
        System.out.println(rob);
    }
    public static int rob(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }
        return Math.max(myRob(Arrays.copyOfRange(nums,0,nums.length-1)),
                myRob(Arrays.copyOfRange(nums,1,nums.length)));

    }
    public static int myRob(int []nums){

        // 存放某个阶段中所偷钱数最多的值
        int [] dp=new int[nums.length+1];
        dp[0]=0;
        dp[1]=nums[0];
        for (int i = 2; i<=nums.length; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[nums.length];
    }
}

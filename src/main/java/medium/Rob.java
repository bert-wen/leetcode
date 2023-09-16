package medium;

/**
 * @projectName: leetcode
 * @package: medium
 * @className: Rob
 * @author: WenHui
 * @description: 打家劫舍 (动态规划）
 * @date: 2023/9/16 22:46
 * @version: 1.0
 */
public class Rob {
    public static void main(String[] args) {
        int[] arr={1,2,3,1};
        int rob = rob(arr);
        System.out.println(rob);
    }
    public static int rob(int[] nums) {
        //  如果没有房子就偷不到钱
        if(nums.length==0){
            return 0;
        }
        int [] dp=new int[nums.length+1];
        dp[0]=0;
        dp[1]=nums[0];
        // 如果是一个房子，那么就投这个房子，如果是两个房子就看哪个房子更多钱
        // 如果是n个房子那么就比较投
        for (int k=2;k<=nums.length;k++){
            dp[k]=Math.max(dp[k-1],dp[k-2]+nums[k-1]);
        }
        return dp[nums.length];

    }


}

package medium.tree;

import java.util.Arrays;

/**
 *  带因子的二叉树
 *  方法：动态规划 + 双指针
 */
public class NumFactoredBinaryTrees {
    public static void main(String[] args) {
        int []arr = {2, 4};
        int i = numFactoredBinaryTrees(arr);
        System.out.println(i);
    }
    public static int numFactoredBinaryTrees(int[] arr) {
        // 排序
        Arrays.sort(arr);
        int n=arr.length;
        long res = 0, mod = 1000000007;
        long [] dp=new long[n];
        for (int i = 0; i < arr.length; i++) {
            dp[i]=1;
            // 这个循环出来后就是根节点为arr[i]时的树的总数
            for (int left=0,right=n-1;right>=left;left++){
                while (right>=left && arr[right]*arr[left]>arr[i]){
                    right--;
                }
                if (right >= left && arr[right]*arr[left]==arr[i]){

                    if (arr[right]==arr[left]){
                        dp[i]=(dp[i]+dp[right]*dp[left])%mod;
                    }else {
                        // 如果arr[right]的值等于arr[left]两个节点可以交换
                        dp[i]=(dp[i]+dp[right]*dp[left]*2)%mod;
                    }

                }
            }
            res=(res+dp[i])%mod;
        }
        return (int)res;
    }
}

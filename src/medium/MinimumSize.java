package medium;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: medium
 * @className: MinimumSize
 * @author: Sveinn
 * @description: TODO
 * @date: 2022/12/20 22:52
 * @version: 1.0
 */
public class MinimumSize {
    public static void main(String[] args) {
        int[] arr={2,2,5,8,2};
        int i = minimumSize(arr, 4);
        System.out.println(i);
    }
    public static int minimumSize(int[] nums, int maxOperations) {
        int right = Arrays.stream(nums).max().getAsInt();
        int left=1;
        int ant=0;
        while (left<=right){
            int mid=(right+left)/2;
            int temp=0;
            for (int num : nums) {
                temp+=(num-1)/mid;
            }
            if (temp<=maxOperations){
                ant=mid;
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return ant;
    }
}

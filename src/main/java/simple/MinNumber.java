package simple;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 从两个数字数组里生成最小数字
 */
public class MinNumber {
    public static void main(String[] args) {
        int []nums1 = {4,1,3}, nums2 = {5,7};
        System.out.println(minNumber(nums1, nums2));

    }
    public static int minNumber(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0;
        while (i<nums1.length && j<nums2.length){
            if (nums1[i]==nums2[j]){
                return nums1[i];
            }else if (nums1[i]>nums2[j]){
                j++;
            }else {
                i++;
            }
        }
        return Math.min(nums1[0], nums2[0]) * 10 + Math.max(nums1[0], nums2[0]);
    }
}

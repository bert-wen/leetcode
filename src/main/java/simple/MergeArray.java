package simple;

import java.util.Arrays;

/**
 * @description: 合并两个有序数组
 * @title: MergeArray
 * @email: 2046641767@qq.com
 * @projectName: leetcode
 * @author: Sveinn
 * @date: 2022/7/31 16:22
 */
public class MergeArray {
    public static void main(String[] args) {
        int []nums1={1,2,3,0,0,0};
        int []nums2={2,5,6};
        merge(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0;
        int j=0;
        int t=0;
        int []temp=new int[m+n];
        while (i<m && j<n){
            if (nums1[i]>=nums2[j]){
                temp[t]=nums2[j];
                j++;
            }else {
                temp[t]=nums1[i];
                i++;
            }
            t++;
        }
        while (i<m){
            temp[t]=nums1[i];
            t++;
            i++;
        }
        while (j<n){
            temp[t]=nums2[j];
            j++;
            t++;
        }
        System.arraycopy(temp, 0, nums1, 0, nums1.length);
    }
}

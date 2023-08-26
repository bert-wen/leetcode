package medium;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: medium
 * @className: NextPermutation(下一个排列）
 * @author: WenHui
 * @description: 从后往前交换
 * @date: 2023/1/7 17:08
 * @version: 1.0
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] nums={1,3,2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void nextPermutation(int[] nums) {
        //先定位到哪里有后面的数大于前面的数
        int temp=nums.length-2;
        while (temp>=0 && nums[temp]>=nums[temp+1]){
            temp--;
        }
        int value=nums.length-1;
        //再看后面的数有没有比这定位的这个数还大的,如果有则交换,然后后面的数字进行反转（因为已经确定了后面的数是从大到小排序的)
        if (temp>=0){
            while (value>temp && nums[value]<=nums[temp]){
                value--;
            }
            exchange(nums,temp,value);
        }
        reverse(nums,temp+1,nums.length-1);

    }
    public static void exchange(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public static void reverse(int[] nums,int i,int j){
        while (i<j){
            exchange(nums,i,j);
            i++;
            j--;
        }
    }
}

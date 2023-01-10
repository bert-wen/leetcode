package medium;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: medium
 * @className: SearchRange
 * @author: WenHui
 * @description: TODO
 * @date: 2023/1/7 20:18
 * @version: 1.0
 */
public class SearchRange {
    public static void main(String[] args) {
        int[] nums={5,7,7,8,8,10};
//        int[] ints = searchRange(nums, 7);
//        System.out.println(Arrays.toString(ints));
        int[] empty={};
        int[] ints1 = searchRangeOptimize(empty, 0);
        System.out.println(Arrays.toString(ints1));
    }
    /**
     * @param nums:
     * @param target:
     * @return int
     * @author WenHui
     * @description 先找出第一个等于target的数来，然后找出第最后一个等于target的数
     * @date 2023/1/8 13:32
     */
    public static int[] searchRangeOptimize(int[] nums, int target){
        int[] ans={-1,-1};
        if (nums.length==0){
            return ans;
        }
        int left=0,right=nums.length-1;
        while (left<right){
            int mid=(left+right)/2;
            if (nums[mid]>=target){
               right=mid;
            }else {
                left=mid+1;
            }
        }
        if (nums[right]!=target){
            return ans;
        }
        ans[0]=right;
        right=nums.length-1;
        while (left<right){
            //防止死循环,当mid+1后相加还是会等于原来的数
            int mid=(left+right+1)/2;
            if (target>=nums[mid]){
                left=mid;
            }else {
                right=mid-1;
            }
        }
        ans[1]=left;
        return ans;
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] ans={-1,-1};
        if (nums==null){
            return ans;
        }
        int left=0,right=nums.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if (nums[mid]==target){
                int i=mid,j=mid;
                while (i<=right){
                    if (i+1<=nums.length-1){
                        if (nums[i+1]==target){
                            i++;
                        }
                    }else {
                        break;
                    }
                }
                while (j>=left){
                    if (j-1>=0){
                        if (nums[j-1]==target){
                            j--;
                        }
                    }else {
                        break;
                    }
                }
                ans[0]=j;
                ans[1]=i;
            }
            if (nums[mid]<target){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return ans;
    }

}

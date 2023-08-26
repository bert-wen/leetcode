package simple;

/**
 * @description: TODO
 * @title: TwoSum
 * @email: 2046641767@qq.com
 * @projectName: leetcode
 * @author: Sveinn
 * @date: 2022/11/11 20:01
 */
public class TwoSum {
    public static void main(String[] args) {

    }
    public int[] twoSum(int[] nums, int target) {
        int[] arr=new int[nums.length];
        int count=-1;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    arr[++count]=i;
                    arr[++count]=j;
                }
            }
        }
        return arr;
    }

}

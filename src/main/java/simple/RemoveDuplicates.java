package simple;

/**
 * @projectName: leetcode
 * @package: simple
 * @className: RemoveDuplicates
 * @author: Sveinn
 * @description: TODO
 * @date: 2023/1/1 20:03
 * @version: 1.0
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int []nums={0,0,1,1,1,2,2,3,3,4};

        int i = removeDuplicates(nums);
        System.out.println(i);
        for (int num : nums) {
            System.out.println(num);
        }
    }
    public static int removeDuplicates(int []nums){
        if (nums.length<2){
            return nums.length;
        }
        int j=0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]!=nums[j]){
                nums[++j]=nums[i];
            }
        }
        return ++j;
   }

}

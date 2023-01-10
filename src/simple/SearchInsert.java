package simple;

/**
 * @projectName: leetcode
 * @package: simple
 * @className: SearchInsert
 * @author: Sveinn
 * @description: TODO
 * @date: 2023/1/2 17:29
 * @version: 1.0
 */
public class SearchInsert {
    public static void main(String[] args) {
        int []nums={1,3,5,6};
        int i = searchInsert(nums, 0);
        System.out.println(i);
    }
    public static int searchInsert(int[] nums, int target){
        if (nums[0]>=target){
            return 0;
        }
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i]<=target && nums[i+1]>=target){
                return i+1;
            }
        }
        return nums.length;
    }
}

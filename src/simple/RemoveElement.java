package simple;

/**
 * @projectName: leetcode
 * @package: simple
 * @className: RemoveElement
 * @author: Sveinn
 * @description: TODO
 * @date: 2023/1/1 20:49
 * @version: 1.0
 */
public class RemoveElement {
    public static void main(String[] args) {
        int []nums={3,2,2,3};
        int i = removeElement(nums, 3);
        System.out.println(i);
        for (int i1 = 0; i1 < nums.length; i1++) {
            System.out.println(nums[i1]);
        }
    }
    public static int removeElement(int[] nums, int val){
        int j=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=val){
                nums[j++]=nums[i];
            }
        }
        return j;
    }
}

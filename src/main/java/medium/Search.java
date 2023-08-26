package medium;

/**
 * @projectName: leetcode
 * @package: medium
 * @className: Search
 * @author: WenHui
 * @description: TODO
 * @date: 2023/1/7 18:57
 * @version: 1.0
 */
public class Search {
    public static void main(String[] args) {
        int[] nums={4,5,6,7,0,1,2};
        int i = binarySearch(nums, 0);
        System.out.println(i);
    }
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==target){
                return i;
            }
        }
        return -1;
    }
    /**
     * @param nums:
     * @param target:
     * @return int
     * @author WenHui
     * @description 针对两段有序的数据进行二分查找
     * @date 2023/1/7 20:14
     */
    public static int binarySearch(int[] nums, int target){
        if (nums==null){
            return 0;
        }
        if (nums.length==1){
            return target==nums[0] ? 0:-1;
        }
        int left=0,right=nums.length-1;
        while (left<=right){
            int mid=(right+left)/2;
            if (nums[mid]==target){
                return mid;
            }
            if (nums[0]<=nums[mid]){
                if (nums[mid]>target && nums[0]<=target){
                    right=mid-1;
                }else {
                    left=mid+1;
                }
            }else {
                if (nums[nums.length-1]>=target && nums[mid]<target){
                    left=mid+1;
                }else {
                    right=mid-1;
                }
            }
        }
        return -1;
    }
}

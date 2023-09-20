package medium;

/**
 *
 * 打家劫舍 IV
 */
public class RobFour {
    public static void main(String[] args) {

        int [] nums = {2,3,5,9};
        int k=2;
        int i = minCapability(nums, k);
        System.out.println(i);
    }
    public static int minCapability(int[] nums, int k) {
        int left = 0, right = 0;
        for (int x : nums) {
            right = Math.max(right, x);
        }
        while (left + 1 < right) { // 开区间写法
            int mid = (left + right) >>> 1;
            if (rob(nums, k, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }
    public static boolean rob(int [] nums,int k,int mx){
        int f0 = 0, f1 = 0;
        for (int x : nums) {
            if (x > mx) {
                f0 = f1;
            } else {
                int tmp = f1;
                f1 = Math.max(f1, f0 + 1);
                f0 = tmp;
            }
        }
        return f1 >= k;
    }

}

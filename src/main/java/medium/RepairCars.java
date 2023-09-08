package medium;

/**
 * 修车的最少时间
 * 二分查找
 */
public class RepairCars {
    public static void main(String[] args) {
        int [] arr={3,1,3,3,1,3};
        long l = repairCars(arr, 42);
        System.out.println(l);
    }

    public static long repairCars(int[] ranks, int cars) {
        long left=0;
        long right= (long) ranks[0] * cars * cars;
        while (left<right){
            int sum = 0;
            long mid=(left+right)>>1;
            // 求一共修理多少辆车
            for (int rank : ranks) {
               sum+=Math.sqrt((double) mid /rank);
            }
            // 要想要找到时间最小，就要往后缩短时间，知道最小时间能找到
            if (sum>=cars){
                right=mid;
            }else {
                left=mid+1;
            }
        }
        return left;
    }
}

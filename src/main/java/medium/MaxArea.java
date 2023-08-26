package medium;

/**
 * @projectName: leetcode
 * @package: medium
 * @className: MaxArea
 * @author: Sveinn
 * @description: TODO
 * @date: 2023/1/4 10:38
 * @version: 1.0
 */
public class MaxArea {
    public static void main(String[] args) {
        int[] height={1,8,6,2,5,4,8,3,7};
        int i = maxArea(height);
        System.out.println(i);
    }
    /**
     * @param height:
     * @return int
     * @author Sveinn
     * @description 双指针(短板越往里面越好)
     * @date 2023/1/4 11:30
     */
    public static int maxArea(int[] height) {
        int l=0,r=height.length-1;
        int temp=0;
        while (l<r){
            temp=Math.max(Math.min(height[l],height[r])*(r-l),temp);
            if (height[l]<height[r]){
                l++;
            }else {
                r--;
            }
        }
        return temp;
    }
    /**
     * @param height:
     * @return int
     * @author Sveinn
     * @description 超时
     * @date 2023/1/4 11:02
     */
    public static int maxAreaTest(int[] height) {
        int max=0;
        int value=0;

        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                value=Math.min(height[i],height[j])*(j-i);
                if(value>max){
                    max=value;
                }
            }
        }
        return max;
    }
}

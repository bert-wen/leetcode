package medium;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: medium
 * @className: EliminateMaximum
 * @author: WenHui
 * @description: 消灭怪物的最大数量
 * @date: 2023/9/3 11:06
 * @version: 1.0
 */
public class EliminateMaximum {
    public static void main(String[] args) {
        int []dist = {1,3,4};
        int []speed = {1,1,1};
        int i = eliminateMaximum(dist, speed);
        System.out.println(i);
    }
    public static int eliminateMaximum(int[] dist, int[] speed) {
        int [] arr= new int[dist.length];
        for (int i = 0; i < dist.length; i++) {
            arr[i]=(dist[i]-1)/speed[i]+1;
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<=i){
                return i;
            }
        }
        return dist.length;
    }
}

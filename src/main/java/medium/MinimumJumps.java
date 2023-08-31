package medium;

import java.util.*;

/**
 * 到家的最少跳跃次数
 * 广度优先搜索
 */
public class MinimumJumps {
    public static void main(String[] args) {
        int [] forbidden = {14,4,18,1,15};
        int a = 3, b = 15, x = 9;
        System.out.println(minimumJumps(forbidden, a, b, x));


    }
    public static int minimumJumps(int[] forbidden, int a, int b, int x) {
        Queue<int []> queue=new ArrayDeque<int []>();
        queue.offer(new int[]{0,1,0});
        int lower=0;
        int upper=Math.max(Arrays.stream(forbidden).max().getAsInt()+a,x)+b;
        Set<Integer> forbiddenSet = new HashSet<>();
        // 用于记录前一步的走向与方向
        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);
        for (int j : forbidden) {
            forbiddenSet.add(j);
        }
       while (!queue.isEmpty()){
           int[] arr= queue.poll();
           int position=arr[0],direction=arr[1],step=arr[2];
           // 如果到达了X就返回否则退出循环返回-1
           if (position==x){
               return step;
           }
           int nextPosition=position+a;
           int nextDirection=1;
           // 一直往前走（深度优先）
           if (nextPosition>=lower && nextPosition<=upper && !forbiddenSet.contains(nextPosition) && !visited.contains(nextPosition*nextDirection)){
                visited.add(nextDirection*nextDirection);
                queue.offer(new int[]{nextPosition,nextDirection,step+1});
           }
           if (direction==1){
               nextPosition=position-b;
               nextDirection=-1;
               if (nextPosition>=lower && nextPosition<=upper && !forbiddenSet.contains(nextPosition) && !visited.contains(nextPosition*nextDirection))
               {
                   visited.add(nextDirection * nextPosition);
                   queue.offer(new int[]{nextPosition, nextDirection, step + 1});
               }
            }
        }
        return -1;
    }
}


package hard;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: hard
 * @className: CollectTheCoins
 * @author: WenHui
 * @description: 收集树中金币（拓扑排序）
 * @date: 2023/9/21 21:55
 * @version: 1.0
 */
public class CollectTheCoins {
    public static void main(String[] args) {
        int [] coins={1,0,0,0,0,1};
        int [][] edges={{0,1},{1,2},{2,3},{3,4},{4,5}};
        int i = collectTheCoins(coins, edges);
        System.out.println(i);

    }
    public static int collectTheCoins(int[] coins, int[][] edges) {
        int n=coins.length;
        List<Integer> g[]=new ArrayList[n];
        Arrays.setAll(g,e->new ArrayList<>());
        int[] deg=new int[n];
        // 构件图
        for (int[] edge : edges) {
            int x=edge[0];
            int y=edge[1];
            g[x].add(y);
            g[y].add(x);
            // 统计每个节点的读数（邻居个数）
            deg[x]++;
            deg[y]++;
        }
        // 剩余边数
        int leftEdges=n-1;
        //  拓扑排序，去掉没有金币的子树
        Queue<Integer> queue=new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (deg[i]==1  && coins[i]==0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            // 删除节点到其父节点
            leftEdges--;
            for (int y: g[queue.poll()]){
                // 没有金币的叶子
                if (--deg[y]==1 && coins[y]==0){
                    queue.add(y);
                }
            }
        }
        // 再次拓扑排序
        for (int i = 0; i < n; i++) {
            // 有金币的叶子
            if (deg[i]==1 && coins[i]==1){
                queue.add(i);
            }
        }
        // 删除所有叶子
        leftEdges-=queue.size();
        for (int x:queue){
            for (int y:g[x]){
                if (--deg[y]==1){
                    leftEdges--;
                }
            }
        }
        return Math.max(leftEdges*2,0);
    }
}

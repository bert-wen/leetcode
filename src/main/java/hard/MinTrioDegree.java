package hard;

import java.util.Arrays;

/**
 *  一个图中连通三元组的最小度数
 *
 */
public class MinTrioDegree {
    public static void main(String[] args) {
        int [][] edges={{1,2},{1,3},{3,2},{4,1},{5,2},{3,6}};
        int i = minTrioDegree(6, edges);
        System.out.println(i);
    }
    public static int minTrioDegree(int n, int[][] edges) {
        // 记录度
        int [] degree=new int[n];
        // 记录邻接矩阵
        int [][] g=new int[n][n];
        // 把图装换成邻接矩阵，并计算每个节点的度（每个节点的度计算了两遍）
        for (int[] edge : edges) {
            int x=edge[0]-1,y=edge[1]-1;
            g[x][y]=g[y][x]=1;
            ++degree[x];
            ++degree[y];
        }
        int count=Integer.MAX_VALUE;
        // 暴力枚举出所有三个点直接都有通路的节点，得到度数最小的三个节点，
        // 因为是无向图所以每次统计度都是统计两次，三个几点的度加起来减掉三个节点之间的连接（2*3）就是连通三元组的度数
        for (int i=0;i<n;i++){
            for (int j=i;j<n;j++){
                if (g[i][j]==1){
                    for (int k=j+1;k<n;k++){
                        if (g[i][k]==1 && g[j][k]==1){
                            count=Math.min(count,degree[i]+degree[j]+degree[k]-6);
                        }
                    }
                }
            }
        }
        return count==Integer.MAX_VALUE ? -1 :count;
    }
}

package medium;

/**
 * 检查骑士巡视方案
 */
public class CheckValidGrid {
    public static void main(String[] args) {
        int [][] grid = {{0,11,16,5,20},{17,4,19,10,15},{12,1,8,21,6},{3,18,23,14,9},{24,13,2,7,22}};
        boolean b = checkValidGrid(grid);
        System.out.println(b);
    }
    public static boolean checkValidGrid(int[][] grid) {
        if (grid[0][0]!=0){
            return false;
        }
        int n=grid.length;
        // 用来记录每次骑士走的位置
        int [][] indices= new int[n*n][2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                indices[grid[i][j]][0]=i;
                indices[grid[i][j]][1]=j;
            }
        }
        for (int i = 0; i < indices.length-1; i++) {
            int x=Math.abs(indices[i+1][0]-indices[i][0]);
            int y=Math.abs(indices[i+1][1]-indices[i][1]);
            // 骑士要走日字所以下一步的横坐标的位置*纵坐标的位置一定会等于2
            if (x*y!=2){
                return false;
            }
        }
        return true;
    }
}

package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * 可以攻击国王的皇后
 */
public class QueensAttackTheKing {
    private final static int[][] directions = {{1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}};
    public static void main(String[] args) {
        int [][] queens = {{0,1},{1,0},{4,0},{0,4},{3,3},{2,4}};
        int []king = {0,0};
        List<List<Integer>> lists = queensAttackTheKing(queens, king);
        System.out.println(lists);
    }
    public static List<List<Integer>> queensAttackTheKing(int[][] queens, int[] king) {
        List<List<Integer>> list=new ArrayList<>();
        boolean [][] isQueen=new boolean[8][8];
        for (int[] queen : queens) {
           isQueen[queen[0]][queen[1]]=true;
        }
        // 8个方向一个方向就只有一个
        for (int[] direction : directions) {
            int x=king[0]+direction[0];
            int y=king[1]+direction[1];
            while (0<=x && x<8 && y>=0 && y<8){
                if (isQueen[x][y]){
                    List<Integer> lis1=new ArrayList<>();
                    lis1.add(x);
                    lis1.add(y);
                    list.add(lis1);
                    break;
                }
                x+=direction[0];
                y+=direction[1];
            }
        }
        return list;
    }
}

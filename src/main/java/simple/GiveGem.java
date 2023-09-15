package simple;

import java.util.Arrays;

/**
 * 宝石补给
 */
public class GiveGem {
    public static void main(String[] args) {
       int [] gem = {3,1,2};
       int [] []operations = {{0,2},{2,1},{2,0}};
        int i = giveGem(gem, operations);
        System.out.println(i);
    }
    public static int giveGem(int[] gem, int[][] operations) {
        for (int[] operation : operations) {
            int source=operation[0];
            int target=operation[1];
            int count= gem[source] / 2;
            gem[source]-=count;
            gem[target]+=count;
        }
        Arrays.sort(gem);
        return Math.abs(gem[gem.length-1]-gem[0]);
    }
}

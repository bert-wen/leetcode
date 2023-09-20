package simple;

public class MinCount {
    public static void main(String[] args) {
        int [] arr={2,3,10};
        System.out.println(minCount(arr));
    }
    public static int minCount(int[] coins) {
        int times=0;
        for (int coin : coins) {
            times+=Math.ceil((double)coin/2);
        }
        return times;
    }
}

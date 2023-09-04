package medium;

/**
 * 买钢笔和铅笔的方案数
 * 暴力枚举
 */
public class WaysToBuyPensPencils {
    public static void main(String[] args) {
        long l = waysToBuyPensPencils(5, 10,10);
        System.out.println(l);
    }
    public static long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long count=0L;
        int num;
        if (total< cost1 && total<cost2){
            return 1L;
        }
        for (int i=0;i<=total/cost1;i++){
            num=cost1*i;
            if (num<=total){
                count++;
            }
            for (int j=0;j<=total/cost2;j++){
                num=num+cost2*j;
                if (num<=total){
                    count++;
                }
            }
            System.out.println(count);
        }
        return count;
    }
    public long countCombinations(int total, int cost1, int cost2) {
        if (total < cost1 && total < cost2) {
            return 1L;
        }

        long count = 0L;
        for (int i = 0; i <= total / cost1; i++) {
            int remainingTotal = total - cost1 * i;
            int maxCost2Quantity = remainingTotal / cost2;

            count += maxCost2Quantity + 1;  // +1 是为了包含不选 cost2 的情况
        }

        return count;
    }
}

package medium;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: medium
 * @className: CloseCost
 * @author: Sveinn
 * @description: TODO
 * @date: 2022/12/4 19:21
 * @version: 1.0
 */
public class CloseCost {
    static int temp;
    public static void main(String[] args) {
        int[] baseCosts={2,3};
        int[] toppingCosts={4,5,100};
        int i = closestCost(baseCosts, toppingCosts, 18);
        System.out.println(i);
    }
    public static int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        temp= Arrays.stream(baseCosts).min().getAsInt();
        for(int i=0;i<baseCosts.length;i++){
            dsf(toppingCosts,0,baseCosts[i],target);
        }
        return temp;
    }
    public static void dsf(int[] toppingCosts,int p,int curCosts,int target){
        //排除超大原材料的情况，可以减少递归次数
        if (Math.abs(temp-target)<curCosts-target) {
            return;
        }
        if(Math.abs(temp-target)>=Math.abs(curCosts-target)){
            if (Math.abs(temp-target)>Math.abs(curCosts-target)){
                temp=curCosts;
            }else {
                //如果成本相同就返回成本最少的
                temp=Math.min(temp,curCosts);
            }
        }
        if (p==toppingCosts.length){
            return;
        }
        //有三种情况
        dsf(toppingCosts,p+1,curCosts,target);
        dsf(toppingCosts,p+1,curCosts+toppingCosts[p],target);
        dsf(toppingCosts,p+1,curCosts+2*toppingCosts[p],target);

    }

}

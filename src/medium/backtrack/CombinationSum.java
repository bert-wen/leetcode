package medium.backtrack;

import java.util.*;
import java.util.logging.XMLFormatter;

/**
 * @projectName: leetcode
 * @package: medium.backtrack
 * @className: CombinationSum
 * @author: WenHui
 * @description: 数组总和
 * @date: 2023/1/10 19:22
 * @version: 1.0
 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] nums={2,3,6,7};
        List<List<Integer>> listList = combinationSum(nums, 7);
        System.out.println(listList);
        Arrays.sort(nums);
        List<List<Integer>> res = combinationSum(nums, 7);
        System.out.println(res);

    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len=candidates.length;
        List<List<Integer>> res=new ArrayList<>();
        Deque<Integer> deque=new ArrayDeque<>();
        dfs1(candidates,0,len,target,deque,res);
        return res;
    }
    /**
     * @param candidates:
     * @param begin:
     * @param len:
     * @param target:
     * @param deque:
     * @param res:
     * @return void
     * @author WenHui
     * @description 递归，把它看成是一棵树
     * @date 2023/1/10 21:04
     */
    public static void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> deque, List<List<Integer>> res){
        if (target<0){
            return ;
        }
        if (target==0){
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int i=begin;i<len;i++){
            deque.addLast(candidates[i]);
            System.out.println("递归前deque="+deque+"target-candidates[i]="+(target-candidates[i]));
            dfs(candidates,i,len,target-candidates[i],deque,res);
            deque.removeLast();
            System.out.println("递归前后deque="+deque+"target-candidates[i]="+(target-candidates[i]));
        }
    }
    /**
     * @param candidates:
     * @param begin:
     * @param len:
     * @param target:
     * @param deque:
     * @param res:
     * @return void
     * @author WenHui
     * @description 通过排序的方式减少递归的次数
     * @date 2023/1/10 21:09
     */
    public static void dfs1(int[] candidates, int begin, int len, int target, Deque<Integer> deque, List<List<Integer>> res){
        if (target<0){
            return ;
        }
        if (target==0){
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int i=begin;i<len;i++){
            //前提是数组已经拍好序了
            if (target-candidates[i]<0){
                break;
            }
            deque.addLast(candidates[i]);
            dfs1(candidates,i,len,target-candidates[i],deque,res);
            deque.removeLast();
        }
    }

}

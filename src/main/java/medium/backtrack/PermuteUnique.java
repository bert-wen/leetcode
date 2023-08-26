package medium.tree.backtrack;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: medium.backtrack
 * @className: PermuteUnique
 * @author: WenHui
 * @description: 全排列
 * @date: 2023/1/22 22:19
 * @version: 1.0
 */
public class PermuteUnique {
    public static void main(String[] args) {
        int[] nums={1,1,3};
        List<List<Integer>> listList = permuteUnique(nums);
        System.out.println(listList);
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        int len=nums.length;
        if (len==0){
            return res;
        }
        Deque<Integer> deque=new ArrayDeque<>();
        //用一个数组来表示该数有没加入队列
        boolean[] used=new boolean[len];
        Arrays.fill(used,false);
        Arrays.sort(nums);
        dfs(len,used,deque,nums,res);
        return res;
    }
    public static void dfs(int len,boolean[] used,Deque<Integer> deque,int[] nums,List<List<Integer>> res){
        if (deque.size()==len){
            res.add(new ArrayList<>(deque));
            return;
        }
        for(int i=0;i<len;i++){
            //去重
            if (i>0 && nums[i]==nums[i-1] && !used[i - 1]){
                continue;
            }
            if (!used[i]){
                deque.addLast(nums[i]);
                used[i]=true;
                dfs(len,used,deque,nums,res);
                deque.removeLast();
                used[i]=false;
            }
        }
    }
}

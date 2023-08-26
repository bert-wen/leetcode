package medium.tree.backtrack;

import com.sun.org.apache.xpath.internal.operations.Neg;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: medium.backtrack
 * @className: Permute
 * @author: WenHui
 * @description: 全排列(使用回溯算法)
 * @date: 2023/1/18 8:52
 * @version: 1.0
 */
public class Permute {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);

    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        int len=nums.length;
        if (len==0){
            return res;
        }
        Deque<Integer> tempQue= new ArrayDeque<>();
        dfs(len,nums,tempQue,res);
        return res;
    }
    public static void dfs(int len,int[] nums, Deque<Integer> tempQue,List<List<Integer>> res){
        if (tempQue.size()==len){
            res.add(new ArrayList<>(tempQue));
            return;
        }
        //for循环变量数组
        for (int i=0;i<len;i++){
            if (tempQue.contains(nums[i])){
                continue;
            }
            tempQue.addLast(nums[i]);
            dfs(len,nums,tempQue,res);
            tempQue.removeLast();
        }
    }
}

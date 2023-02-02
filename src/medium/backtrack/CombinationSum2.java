package medium.backtrack;

import org.omg.CORBA.IRObject;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: medium.backtrack
 * @className: CombinationSum2
 * @author: WenHui
 * @description: TODO
 * @date: 2023/1/17 16:52
 * @version: 1.0
 */
public class CombinationSum2 {
    public static void main(String[] args) {
        int[] arr={10,1,2,7,6,1,5};
        Arrays.sort(arr);
        List<List<Integer>> listList = combinationSum2(arr, 8);
        System.out.println(listList);
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len=candidates.length;
        List<List<Integer>> list=new ArrayList<>();
        Deque<Integer> tempList=new ArrayDeque<>();
        dfs(0,len,candidates,tempList,list,target);
        return list;
    }
    public static void dfs(int start, int len, int[] candidates, Deque<Integer> tempList, List<List<Integer>> list, int target){
        if (target==0){
            list.add(new ArrayList<>(tempList));
            return;
        }
        if (target<0){
            return;
        }
        for (int i=start;i<len;i++){
            if (target-candidates[i]<0){
                break;
            }
            //去重操作，如果有3个或者三个以上的数字重复
            if (i>start && candidates[i]==candidates[i-1]){
                continue;
            }
            tempList.addLast(candidates[i]);
            dfs(i+1,len,candidates,tempList,list,target-candidates[i]);
            tempList.removeLast();
        }
    }
}

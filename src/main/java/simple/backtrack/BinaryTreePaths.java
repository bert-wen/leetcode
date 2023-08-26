package simple.backtrack;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_ADDPeer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @projectName: leetcode
 * @package: simple.backtrack
 * @className: BinaryTreePaths
 * @author: WenHui
 * @description: TODO
 * @date: 2023/1/13 14:29
 * @version: 1.0
 */
public class BinaryTreePaths {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
         }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
    public static void main(String[] args) {
        int[] nums={1,2,3,0,5};
        TreeNode binaryTree = createBinaryTree(nums);
        System.out.println(binaryTree);

    }
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list=new ArrayList<>();
        if (root==null){
            return null;
        }
        dfs(root,"",list);
        return list;
    }

    /**
     * @param treeNode:
     * @param path:
     * @param list:
     * @return void
     * @author WenHui
     * @description 深度优先搜索
     * @date 2023/1/14 14:32
     */
    public static void dfs(TreeNode treeNode,String path,List<String> list){
        if (treeNode!=null){
            StringBuilder stringBuilder=new StringBuilder(path);
            stringBuilder.append(treeNode.val);
            //如果是没有子节点了（叶子节点）就加入答案
            if (treeNode.left==null && treeNode.right==null){
                list.add(stringBuilder.toString());
            }else {
                stringBuilder.append("->");
                dfs(treeNode.left,stringBuilder.toString(),list);
                dfs(treeNode.right,stringBuilder.toString(),list);
            }
        }
    }
    /**
     * @param root:
     * @return List<String>
     * @author WenHui
     * @description 广度优先搜索利用队列存储遍历的信息
     * @date 2023/1/14 15:02
     */
    public static List<String> breadthSearch(TreeNode root){
        List<String> paths=new ArrayList<>();
        if (root==null){
            return null;
        }
        Queue<TreeNode> ndoeQueue=new ArrayDeque<>();
        Queue<String> pathQueue=new ArrayDeque<>();
        //先把root放进队列
        ndoeQueue.offer(root);
        pathQueue.offer(Integer.toString(root.val));
        while(!ndoeQueue.isEmpty()){
            TreeNode treeNode = ndoeQueue.poll();
            String path = pathQueue.poll();
            //如果是叶子节点那么久得到路径
            if (treeNode.left==null && treeNode.right==null){
                paths.add(path);
            }else {
                if (treeNode.left!=null){
                    ndoeQueue.offer(treeNode.left);
                    pathQueue.offer(new StringBuilder(path).append("->").append(treeNode.left.val).toString());
                }
                if (treeNode.right!=null){
                    ndoeQueue.offer(treeNode.right);
                    pathQueue.offer(new StringBuilder(path).append("->").append(treeNode.right.val).toString());
                }
            }
        }
        return paths;
    }
    static int i=0;
    public static TreeNode createBinaryTree(int[] arr){
        if (arr.length == 0){
            return null;
        }
        TreeNode treeNode=new TreeNode();
        if (i<arr.length){
            treeNode.val=arr[i++];
            if (treeNode.val==0){
                return null;
            }else {
                treeNode.left=createBinaryTree(arr);
                treeNode.right=createBinaryTree(arr);
            }
        }
        return treeNode;
    }
}

package medium.tree;

import tree.Tree;
import tree.TreeNode;

/**
 * 最深叶节点的最近公共祖先
 */
public class LcaDeepestLeaves {
    static TreeNode ans;
    static Integer maxDepth=-1;
    public static void main(String[] args) {
        Integer [] arr={3,4,5,6,};
        TreeNode treeNode = Tree.buildTree(arr);
        System.out.println(treeNode);
        TreeNode treeNode1 = lcaDeepestLeaves(treeNode);
        System.out.println(treeNode1);
    }

    public static TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root,0);
        return ans;
    }
    public static int dfs(TreeNode root,Integer depth){
        // 递归结束条件
        if (root==null){
            maxDepth=Math.max(depth,maxDepth);
            return depth;
        }

        int leftDepthLength=dfs(root.left,depth+1);
        int rightDepthLength=dfs(root.right,depth+1);
        if (leftDepthLength==rightDepthLength && leftDepthLength==maxDepth){
            ans=root;
        }
        return Math.max(leftDepthLength,rightDepthLength);
    }
}

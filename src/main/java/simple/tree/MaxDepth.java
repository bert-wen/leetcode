package simple.tree;

import tree.TreeNode;

/**
 *  二叉树的最大深度
 */
public class MaxDepth {
    int maxDepth=-1;
    public static void main(String[] args) {

    }
    public int maxDepth(TreeNode root) {
        return dfs(root,1);
    }
    public Integer dfs(TreeNode treeNode,Integer depth){
        if (treeNode==null){
            maxDepth=Math.max(depth,maxDepth);
            return depth;
        }
        dfs(treeNode.right,depth+1);
        dfs(treeNode.left,depth+1);
        return maxDepth;
    }
}

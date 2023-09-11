package simple.tree;

import tree.TreeNode;

/**
 * 二叉树的最小深度
 */
public class MinDepth {
    public static void main(String[] args) {

    }
    public int minDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        int leftDepth=minDepth(root.left);
        int rightDepth=minDepth(root.right);
        // 当左右节点有一个为空的时候
        return root.left==null || root.right==null ? (leftDepth+rightDepth)+1 : Math.min(leftDepth,rightDepth)+1;
    }

}

package simple.tree;

import tree.TreeNode;

/**
 * 平衡二叉树
 */
public class IsBalanced {
    public static void main(String[] args) {

    }
    public boolean isBalanced(TreeNode root) {
        if (root==null){
            return true;
        }
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    public Integer maxDepth(TreeNode root){
        if (root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}

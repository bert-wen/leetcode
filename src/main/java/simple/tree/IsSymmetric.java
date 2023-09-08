package simple.tree;

import tree.TreeNode;

import java.util.Objects;

/**
 * 对称二叉树
 */
public class IsSymmetric {
    public static void main(String[] args) {

    }
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left,root.right);
    }
    public boolean isMirror(TreeNode leftNode,TreeNode rightNode){
            if (leftNode==null && rightNode==null){
                return true;
            }
            if (leftNode==null || rightNode==null){
                return false;
            }
            return Objects.equals(leftNode.val, rightNode.val) && isMirror(leftNode.left,rightNode.right) && isMirror(leftNode.right,rightNode.left);
    }
}

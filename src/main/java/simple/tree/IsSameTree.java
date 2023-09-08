package simple.tree;

import tree.Tree;
import tree.TreeNode;

import java.util.Objects;

/**
 * 相同的树
 */
public class IsSameTree {
    public static void main(String[] args) {

    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null){
            return true;
        }
        if (p==null || q==null){
            return false;
        }
        return Objects.equals(p.val, q.val) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}

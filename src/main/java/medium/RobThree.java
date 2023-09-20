package medium;

import tree.TreeNode;

/**
 * todo
 * 打家劫舍 III (动态规划)
 */
public class RobThree {
    public static void main(String[] args) {

    }
    public int rob(TreeNode root) {

        return 1;
    }
    public void def(TreeNode root){
        def(root.right);
    }
}

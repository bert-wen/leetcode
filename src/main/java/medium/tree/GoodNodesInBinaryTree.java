package medium.tree;

import tree.TreeNode;

/**
 *  统计二叉树中好节点的数目
 */
public class GoodNodesInBinaryTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3,
                new TreeNode(1,
                        new TreeNode(3,null,null),null),
                new TreeNode(4,new TreeNode(1,null,null),new TreeNode(5,null,null)));
        System.out.println(node);
        System.out.println(goodNodes(node));
    }
    public static int goodNodes(TreeNode root) {
        return dfs(root,Integer.MIN_VALUE);
    }
    public static Integer dfs(TreeNode root,Integer pathMax){
        if (root==null){
            return 0;
        }
        int temp=0;
        // 如果碰到了比当前大的节点就直接可以判定为当前节点就是最好节点
        if (root.val>=pathMax){
            temp++;
            pathMax=root.val;
        }
        temp+=dfs(root.left,pathMax)+dfs(root.right,pathMax);
        return temp;
    }
}

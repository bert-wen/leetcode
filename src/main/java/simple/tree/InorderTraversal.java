package simple.tree;

import tree.Tree;
import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 */
public class InorderTraversal {
    public static void main(String[] args) {
        Integer [] root = {1,null,null,null,2,3};
        TreeNode treeNode = Tree.buildTree(root);
        System.out.println(treeNode);
        List<Integer> list = inorderTraversal(treeNode);
        System.out.println(list);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        dfs(root,list);
        return list;
    }
    public static void dfs(TreeNode root,List<Integer> integerList) {
        if (root==null){
          return;
        }
        integerList.add(root.val);
        dfs(root.left,integerList);
        dfs(root.right,integerList);
    }
}

package medium.tree;

import tree.Tree;
import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *
 * 序列化和反序列化二叉搜索树
 *  方法：
 */
public class Codec {
    public static void main(String[] args) {
        Integer [] arr={2,1,3};
        TreeNode treeNode1 = Tree.bulidBST(arr);
        String serialize = serialize(treeNode1);
        System.out.println(treeNode1);
        System.out.println(serialize);
        TreeNode deserialize = deserialize(serialize);
        System.out.println(deserialize);
    }
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        postOrder(root,list);
        String string = list.toString();
        return string.substring(1,string.length()-1);
    }
    public static void postOrder(TreeNode root,List<Integer> list){
        if (root==null){
            return ;
        }
        postOrder(root.left,list);
        postOrder(root.right,list);
        list.add(root.val);
    }
    private static TreeNode construct(int lower, int upper, Deque<Integer> stack){
        if (stack.isEmpty() || stack.peek()>upper || stack.peek()< lower){
            return null;
        }
        Integer val = stack.pop();
        TreeNode root = new TreeNode(val);
        root.right=construct(val,upper,stack);
        root.left=construct(lower,val,stack);
        return root;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data.isEmpty()){
            return null;
        }
        Deque<Integer> stack=new ArrayDeque<>();
        String[] split = data.split(", ");
        for (String s : split) {
            stack.push(Integer.parseInt(s));
        }
        return construct(Integer.MIN_VALUE,Integer.MAX_VALUE,stack);
    }
}

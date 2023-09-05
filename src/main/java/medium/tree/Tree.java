package medium.tree;

/**
 *  生成树
 */
public class Tree {
    TreeNode treeNode;
    // 用数组建立二叉排序树

    public Tree(TreeNode treeNode) {
        this.treeNode = treeNode;
    }

    public static TreeNode bulidBST(int[] A) {
        TreeNode root = new TreeNode(A[0]);
        for (int i=1; i<A.length; i++) {
            createBST(root, A[i]);
        }
        return root;
    }
    private static void createBST(TreeNode node, int val) {
        if (val < node.val) {
            if (node.left == null) {
                node.left = new TreeNode(val);
            } else
                createBST(node.left, val);
        } else {
            if (node.right == null) {
                node.right = new TreeNode(val);
            } else
                createBST(node.right, val);
        }

    }

    public static void main(String[] args) {
        int [] arr={5,3,2};
        TreeNode treeNode1 = bulidBST(arr);
        System.out.println(treeNode1);
    }
}

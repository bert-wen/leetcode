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
    public static TreeNode buildTree(int[] arr) {
       return createTree(arr,0);
    }
    private static TreeNode createTree(int [] arr,int index) {
        if (index<0 || index>=arr.length){
            return null;
        }
        TreeNode node = new TreeNode(arr[index]);
        node.left=createTree(arr,2*index+1);
        node.right=createTree(arr,2*index+2);
        return node;
    }
    /**
     * 生成二叉搜索树
     * @param node 数的根节点
     * @param val 节点的值
     */
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
        int [] arr={3,5,1,6};
        TreeNode treeNode1 = buildTree(arr);
        System.out.println(treeNode1);
    }
}

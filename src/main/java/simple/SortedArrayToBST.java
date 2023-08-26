package simple;

/**
 * @projectName: leetcode
 * @package: simple
 * @className: SortedArrayToBST
 * @author: Sveinn
 * @description: 基本递归
 * @date: 2023/1/3 15:42
 * @version: 1.0
 */
public class SortedArrayToBST {
    static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
    public static void main(String[] args) {
        int[] num={-10,-3,0,5,9};
        TreeNode treeNode = sortedArrayToBST(num);
        System.out.println(treeNode);

    }
    public static TreeNode sortedArrayToBST(int[] nums) {
       return getNode(nums,0,nums.length-1);
    }
    public static TreeNode getNode(int[] nums,int left,int right){
        if (left>right){
            return null;
        }
        TreeNode treeNode = new TreeNode();
        int mid=(left+right+1)/2;
        treeNode.val=nums[mid];
        treeNode.left=getNode(nums,left,mid-1);
        treeNode.right=getNode(nums,mid+1,right);
        return treeNode;
    }
}

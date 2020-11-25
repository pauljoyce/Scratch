package LeetCode;

import tree.TreeNode;

/**
 * @Author: mengchao
 * @Date: 2020/11/25 23:10
 */
public class LeetCode104 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public static int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            if (left<right){
                return right + 1;
            }else {
                return left + 1;
            }
        }

    }

    public static void main(String[] args) {
    }
}

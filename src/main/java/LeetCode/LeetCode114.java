package LeetCode;

/**
 * TODO 待研究
 * @Author: mengchao
 * @Date: 2020/11/26 19:33
 */
public class LeetCode114 {
     public class TreeNode {
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
     }

    public static void main(String[] args) {

    }

    /**
     * flatten(left); flatten(right); 这两行走完之后，
     * 左右都是已经展开完成的（因为这个函数的定义如此，传入什么节点，什么节点就会展开完完毕，记住函数定义就是递归的精髓所在），
     * 既然左右都展开完成了，那么 root.left = null; root.right = left; 这两行的意思是把root的左节点斩断，
     * 把left树连接到root的右边，然后cursor是为了找到连接之后的树的最底端，把right树连接在最底端，也就是连接在left树之后，
     * 最后的结果就是 root节点 右连接 left树 右连接 right树，评论区没法发图片也只能描述到这了
     * @param root
     */
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right != null) {
            root = root.right;
        }
        root.right = tmp;
    }

}

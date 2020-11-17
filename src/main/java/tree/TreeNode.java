package tree;

import lombok.Data;

/**
 * @Author: mengchao
 * @Date: 2020/11/17 22:33
 */
@Data
public class TreeNode {
    private int value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int value){
        this.value = value;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode1.setLeft(treeNode2);
        treeNode1.setRight(treeNode3);
        treeNode3.setLeft(treeNode4);
        treeNode3.setRight(treeNode5);

        preTraverseBtree(treeNode1);

    }

    public static void preTraverseBtree(TreeNode rootTreeNode){
        if (rootTreeNode!=null){
            System.out.println(rootTreeNode.getValue());
            preTraverseBtree(rootTreeNode.getLeft());
            preTraverseBtree(rootTreeNode.getRight());
        }
    }

    public static void inTraverseBTree(TreeNode rootTreeNode){
        if (rootTreeNode!=null){
            inTraverseBTree(rootTreeNode.getLeft());
            System.out.println(rootTreeNode.getValue());
            inTraverseBTree(rootTreeNode.getRight());
        }
    }

}

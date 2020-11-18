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
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(6);

        treeNode1.setLeft(treeNode2);
        treeNode1.setRight(treeNode3);
        treeNode3.setLeft(treeNode4);
        treeNode3.setRight(treeNode5);

        int i=getMax(treeNode1);
        System.out.println();
    }

    /**
     * 前序遍历
     * @param rootTreeNode
     */
    public static void preTraverseBtree(TreeNode rootTreeNode){
        if (rootTreeNode!=null){
            System.out.println(rootTreeNode.getValue());
            preTraverseBtree(rootTreeNode.getLeft());
            preTraverseBtree(rootTreeNode.getRight());
        }
    }

    /**
     * 中序遍历
     * 如果对一个二叉查找树遍历，结果是asc排好序的
     * @param rootTreeNode
     */
    public static void inTraverseBTree(TreeNode rootTreeNode){
        if (rootTreeNode!=null){
            inTraverseBTree(rootTreeNode.getLeft());
            System.out.println(rootTreeNode.getValue());
            inTraverseBTree(rootTreeNode.getRight());
        }
    }

    /**
     * 计算树的最大高度
     * @param treeNode
     * @return
     */
    public static int getHeight(TreeNode treeNode){
        if (treeNode==null){
            return 0;
        }else {
            int left = getHeight(treeNode.getLeft());
            int right = getHeight(treeNode.getRight());

            int max = left;
            if (right>max){
                max = right;
            }
            return max + 1;
        }
    }

    /**
     * 计算二叉树最大值
     * @param treeNode
     * @return
     */
    public static int getMax(TreeNode treeNode){
        if (treeNode==null){
            return -1;
        }else {
            int left = getMax(treeNode.getLeft());
            int right = getMax(treeNode.getRight());

            int currentRootValue = treeNode.getValue();
            int max = left;
            if (right>left){
                max = right;
            }
            if (currentRootValue>max){
                max = currentRootValue;
            }
            return max;
        }
    }

}

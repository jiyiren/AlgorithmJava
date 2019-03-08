package algorithm.jianzhi;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/13 下午4:06
 * @Description 面试题7：重建二叉树：根据前序遍历和中序遍历重建二叉树
 */

public class J07_RebuildBinaryTree {

    /**
     * 利用中序遍历的root在中间来 二分查找 递归，但需要前序遍历的targetIndex作为二分的条件
     *
     * @param preOrder
     * @param inOrder
     * @return
     */
    public static BinaryTreeNode rebuildTree(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null) {
            return null;
        }
        return reBuild(preOrder, inOrder, 0, inOrder.length - 1, 0);
    }

    /**
     * 递归方法
     *
     * @param preOrder    前序遍历数组
     * @param inOrder     中序遍历数组
     * @param startIndex  中序遍历数组的起始位置
     * @param endIndex    中序遍历数组的结束位置
     * @param targetIndex 前序遍历数组的root位置, 前序遍历中的位置
     * @return
     */
    public static BinaryTreeNode reBuild(int[] preOrder, int[] inOrder, int startIndex, int endIndex, int targetIndex) {
        // 前序数组超出索引长则返回null
        if (startIndex > endIndex || targetIndex >= preOrder.length) {
            return null;
        }
        // 根据前序数组找到二分条件目标
        int middle = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            if (inOrder[i] == preOrder[targetIndex]) {
                middle = i;
                break;
            }
        }
        //构建树，注意在右子树需要跨越左分枝数目，才能得到右子树的根索引
        BinaryTreeNode root = new BinaryTreeNode(preOrder[targetIndex]);
        root.left = reBuild(preOrder, inOrder, startIndex, middle - 1, targetIndex + 1);
        root.right = reBuild(preOrder, inOrder, middle + 1, endIndex, targetIndex + middle - startIndex + 1);
        return root;
    }

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode root = rebuildTree(preOrder, inOrder);
        breadthFirstTraverse(root);
        System.out.println();
        preOrderRecur(root);
    }

    /**
     * 广度优先遍历，又称层次遍历二叉树
     *
     * @param root
     */
    public static void breadthFirstTraverse(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        BinaryTreeNode currentNode = null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            System.out.print(currentNode.value + " ");
            if (currentNode.left != null)
                queue.offer(currentNode.left);
            if (currentNode.right != null)
                queue.offer(currentNode.right);
        }
    }

    /**
     * 先序遍历树
     *
     * @param root
     */
    public static void preOrderRecur(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }
}

package algorithm.jianzhi;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/22 下午1:14
 * @Description 面试题54：找出二叉搜索树中第k大的节点
 */

public class J54_Knumber {

    static class MInt {
        int k = 0;

        MInt(int k) {
            this.k = k;
        }
    }

    public static BinaryTreeNode kthNode(BinaryTreeNode root, int k) {
        if (root == null || k == 0) {
            return null;
        }
        return middleRec(root, new MInt(k));
    }

    public static BinaryTreeNode middleRec(BinaryTreeNode root, MInt k) {
        BinaryTreeNode target = null;
        if (root.left != null) {
            target = middleRec(root.left, k);
        }
        if (target == null) {
            if (k.k == 1) {
                target = root;
            }
            k.k--;
        }
        if (target == null && root.right != null) {
            target = middleRec(root.right, k);
        }
        return target;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(8);
        BinaryTreeNode node1 = new BinaryTreeNode(4);
        BinaryTreeNode node2 = new BinaryTreeNode(12);
        BinaryTreeNode node3 = new BinaryTreeNode(2);
        BinaryTreeNode node4 = new BinaryTreeNode(6);
        BinaryTreeNode node5 = new BinaryTreeNode(10);
        BinaryTreeNode node6 = new BinaryTreeNode(14);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node4.right = new BinaryTreeNode(7);
        System.out.println(kthNode(root, 1).value);
        System.out.println(kthNode(root, 2).value);
        System.out.println(kthNode(root, 3).value);
        System.out.println(kthNode(root, 4).value);
        System.out.println(kthNode(root, 5).value);
        System.out.println(kthNode(root, 6).value);
        System.out.println(kthNode(root, 7).value);
    }
}

package algorithm.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/3/24 下午10:25
 * @Description
 */

public class BinaryTree {

    private Node root;

    public BinaryTree() {
        root = null;
    }

    /**
     * 构建一颗二叉搜索树
     *
     * @param value
     */
    public void insertNode(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        Node curNode = root;
        while (true) {
            if (value < curNode.value) {
                if (curNode.left == null) {
                    curNode.left = new Node(value);
                    break;
                }
                curNode = curNode.left;
            } else {
                if (curNode.right == null) {
                    curNode.right = new Node(value);
                    break;
                }
                curNode = curNode.right;
            }
        }
    }

    public Node getRoot() {
        return root;
    }

    /**
     * 先序遍历树
     *
     * @param root
     */
    public static void preOrderRecur(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }


    /**
     * 先序非递归遍历树
     *
     * @param root
     */
    public static void preOrderNoRecur(Node root) {
        if (root == null) {
            return;
        }
        LinkedList<Node> stack = new LinkedList<>();
        Node cur = root;
        // 当前结点不为空 或者 栈不为空 就要进行循环
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                System.out.print(cur.value + " ");
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()) {
                cur = stack.pop();
                cur = cur.right;
            }
        }
    }

    /**
     * 中序遍历树递归
     *
     * @param root
     */
    public static void inOrderRecur(Node root) {
        if (root == null) {
            return;
        }
        inOrderRecur(root.left);
        System.out.print(root.value + " ");
        inOrderRecur(root.right);
    }

    /**
     * 中序遍历非递归
     *
     * @param root
     */
    public static void inOrderNoRecur(Node root) {
        if (root == null) {
            return;
        }
        LinkedList<Node> stack = new LinkedList<>();
        Node curNode = root;
        while (curNode != null || !stack.isEmpty()) {
            //一直循环到二叉排序树最左端的叶子结点（currentNode是null）
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            if (!stack.isEmpty()){
                curNode = stack.pop();
                System.out.print(curNode.value + " ");
                curNode = curNode.right;
            }

        }
    }

    /**
     * 后序遍历树
     *
     * @param root
     */
    public static void postOrderRecur(Node root) {
        if (root == null) {
            return;
        }
        postOrderRecur(root.left);
        postOrderRecur(root.right);
        System.out.print(root.value + " ");
    }

    /**
     * 后序遍历非递归
     *
     * @param root
     */
    public static void postOrderNoRecur(Node root) {
        if (root == null) {
            return;
        }
        LinkedList<Node> stack = new LinkedList<>();
        Node curNode = root;
        Node rightNode = null;
        // 一直循环到二叉排序树最左端的叶子结点（currentNode是null）
        while (curNode != null || !stack.isEmpty()) {
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            if (!stack.isEmpty()) {
                curNode = stack.pop();
                // 当前结点没有右结点或上一个结点（已经输出的结点）是当前结点的右结点，则输出当前结点
                // 为什么要加curNode.right == rightNode，因为curNode.right==null只能判断叶子节点的输出，
                // 而如果是非叶子节点，也就是某个已经输出的右结点的父结点，那么要输出它就得判断上次输出的是否为其右节点
                // 这样可保证 左右中输出
                while (curNode.right == null || curNode.right == rightNode) {
                    System.out.print(curNode.value + " ");
                    rightNode = curNode;
                    if (stack.isEmpty()) {
                        return;
                    }
                    curNode = stack.pop();
                }
                stack.push(curNode);
                //还有右结点没有遍历
                curNode = curNode.right;
            }
        }
    }

    /**
     * 广度优先遍历，又称层次遍历二叉树
     *
     * @param root
     */
    public static void breadthFirstTraverse(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        Node currentNode = null;
        queue.offer(root);
//        queue.sz
        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            System.out.print(currentNode.value + " ");
            if (currentNode.left != null)
                queue.offer(currentNode.left);
            if (currentNode.right != null)
                queue.offer(currentNode.right);
        }
    }
}

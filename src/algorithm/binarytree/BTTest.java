package algorithm.binarytree;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/7 上午10:14
 * @Description
 */

public class BTTest {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insertNode(35);
        tree.insertNode(20);
        tree.insertNode(15);
        tree.insertNode(16);
        tree.insertNode(29);
        tree.insertNode(28);
        tree.insertNode(30);
        tree.insertNode(40);
        tree.insertNode(50);
        tree.insertNode(45);
        tree.insertNode(55);
        System.out.println("PRE:");
        //先序递归   35 40 50 55 45 20 29 30 28 15 16
        tree.preOrderRecur(tree.getRoot());
        //先序非递归 35 40 50 55 45 20 29 30 28 15 16
        System.out.println();
        tree.preOrderNoRecur(tree.getRoot());

        System.out.println("\nIN:");
        //中序递归   55 50 45 40 35 30 29 28 20 16 15
        tree.inOrderRecur(tree.getRoot());
        //中序非递归 55 50 45 40 35 30 29 28 20 16 15
        System.out.println();
        tree.inOrderNoRecur(tree.getRoot());


        System.out.println("\nPOST:");
        //后序递归      55 45 50 40 30 28 29 16 15 20 35
        tree.postOrderRecur(tree.getRoot());
        System.out.println();
        //后序遍历非递归 55 45 50 40 30 28 29 16 15 20 35
        tree.postOrderNoRecur(tree.getRoot());

        //广度优先遍历   35 40 20 50 29 15 55 45 30 28 16
//        tree.breadthFirstTraverse(tree.getRoot());
    }
}

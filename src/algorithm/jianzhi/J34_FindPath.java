package algorithm.jianzhi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/19 下午1:17
 * @Description
 *
 * 面试题34：二叉树中和为某一值的路径
 */

public class J34_FindPath {

    public static void findPath(BinaryTreeNode root,int expectedValue){
        if(root==null){
            return;
        }
        List<Integer> mstack = new ArrayList<>();
        int curSum = 0;
        findP(root,mstack,expectedValue,curSum);

    }

    /**
     * 递归判断当前节点是否是叶子节点，是则进一步判断是否需要打印，否则递归判断左右儿子，最后将当前节点移除列表
     * @param root
     * @param mstack
     * @param expectedValue
     * @param curSum
     */
    public static void findP(BinaryTreeNode root,List<Integer> mstack,int expectedValue,int curSum){
        if(root==null){
            return;
        }
        curSum += root.value;
        mstack.add(root.value);
        if (root.right==null && root.left==null && curSum == expectedValue){
            printmStack(mstack);
        }
        findP(root.left,mstack,expectedValue,curSum);
        findP(root.right,mstack,expectedValue,curSum);
        mstack.remove(mstack.size()-1);
    }


    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        BinaryTreeNode node1 = new BinaryTreeNode(5);
        BinaryTreeNode node2 = new BinaryTreeNode(12);
        BinaryTreeNode node3 = new BinaryTreeNode(4);
        BinaryTreeNode node4 = new BinaryTreeNode(7);

        root.left = node1;root.right=node2;
        node1.left=node3;node1.right=node4;
        node2.left=null;node2.right=null;
        node3.left=null;node3.right=null;
        node4.left=null;node4.right=null;
        findPath(root,22);
    }

    public static void printmStack(List<Integer> mstack){
        for (int i=0;i<mstack.size();i++){
            System.out.print(mstack.get(i)+" ");
        }
        System.out.println();
    }
}

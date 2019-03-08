package problem.leetcode;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/8 下午7:02
 * @Description
 *
 * 给定一个单元链表，元素按升序排序，将其转换为高度平衡的BST。

    对于这个问题，一个高度平衡的二叉树是指：其中每个节点的两个子树的深度相差不会超过 1 的二叉树。



    示例:

    给定的排序链表： [-10, -3, 0, 5, 9],

    则一个可能的答案是：[0, -3, 9, -10, null, 5]

         0
        / \
      -3   9
      /   /
    -10  5
 *
 */

public class L109_LinkTree {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        return buildTree(head,null);
    }

    /**
     * 链表通常用首尾标识找寻中间值
     * @param head
     * @param tail
     * @return
     */
    public TreeNode buildTree(ListNode head,ListNode tail){
        if(head==tail){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=tail && fast.next!=tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = buildTree(head,slow);//注意这里
        root.right = buildTree(slow.next,tail);
        return root;
    }
}

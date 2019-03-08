package algorithm.jianzhi;

import java.util.Stack;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/13 下午3:20
 * @Description
 *
 * 面试题6：从尾到头打印链表
 *
 */

public class J06_FromTailPrintLinked {

    public static void fromTailPrint(LinkedNode head){
        Stack<Integer> stack = new Stack<>();
        LinkedNode mhead = head;
        while (mhead!=null){
            stack.push(mhead.value);
            mhead=mhead.next;
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }

    public static void main(String[] args) {
        LinkedNode head = new LinkedNode(0);
        LinkedNode next = head;
        for(int i=1;i<10;i++){
            LinkedNode node = new LinkedNode(i);
            next.next = node;
            next = node;
        }
        fromTailPrint(head);
    }


}

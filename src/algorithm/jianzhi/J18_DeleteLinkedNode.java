package algorithm.jianzhi;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/17 下午1:05
 * @Description
 *
 * 面试题18：删除链表的节点
 *
 */

public class J18_DeleteLinkedNode {

    /**
     * 1.
     * 平均O(1)时间内删除链表指定节点
     * 删除前n-1个节点用O(1)时间，删除第n个时间为O(n),因此平均时间为[(n-1)*O(1)+O(n)]/n，因此平均时间为O(1)
     * @param head
     * @param toDeleted
     */
    public static void deleteNode(LinkedNode head, LinkedNode toDeleted){
        if(head == null || toDeleted == null){
            return;
        }
        if(toDeleted.next ==null){
            // 下一个节点为空，则直接删除当前结点
            if(head==toDeleted){
                //只有一个节点
                head = null;
            }else{
                //删除尾节点
                LinkedNode tmp = head;
                while (tmp.next!=toDeleted){
                    tmp = tmp.next;
                }
                tmp.next = null;
            }
        }else{
            // 否则记录下个结点的值 赋予当前节点，删除下个结点，并将当前节点next指向下下个。
            LinkedNode p = toDeleted.next.next;
            toDeleted.value = toDeleted.next.value;
            toDeleted.next = null;
            toDeleted.next = p;
        }
    }

    /**
     * 2. 删除链表中重复的节点
     * 如：    1->2->3->3->4->4->5
     * 删除后： 1->2->5
     *
     * 1. 需要两个指针，一个指向前一个节点preNode，另一个指向当前节点node，如果遇到相等的节点，node向后移动，preNode不动，
     *    存下node.val方便后面的比较，直到遇到node和node.next不相等，preNode就可以指向node.next
     * 2. 注意：链表开头可能就开始有重复的节点，所以默认preNode=null，在后面的给preNode赋值的时候，若preNode为null，
     *    那就把pHead设置为node.next
     * @param head
     */
    public static LinkedNode deleteDuplication(LinkedNode head){
        if(head==null || head.next==null){
            return null;
        }
        LinkedNode preNode = null;
        LinkedNode curNode = head;
        while (curNode!=null){
            // curNode记录如果为重复值的最后一个重复值
            if(curNode.next!=null && curNode.value == curNode.next.value){
                int value = curNode.value;
                while(curNode.next!=null && curNode.next.value==value){
                    curNode = curNode.next;
                }
                if(preNode == null){
                    // 假设前head几个都是重复的，那么就将head设置为curNode重复值最后一个的下一个
                    head = curNode.next;
                }else{
                    // 这里是preNode的下一个等于curNode的下一个
                    preNode.next = curNode.next;
                }
            }else{
                preNode = curNode;
            }
            curNode = curNode.next;
        }
        return head;
    }



    public static void main(String[] args) {
        LinkedNode head = new LinkedNode(0);
        LinkedNode node1 = new LinkedNode(1);
        LinkedNode node2 = new LinkedNode(1);
        LinkedNode node3 = new LinkedNode(3);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        printLinked(head);

//        deleteNode(head,node1);
//        deleteNode(head,node3);
//        System.out.println();
//        printLinked(head);


        LinkedNode newHead = deleteDuplication(head);
        System.out.println();
        printLinked(newHead);
    }

    public static void printLinked(LinkedNode head){
        LinkedNode tmp = head;
        while (tmp!=null){
            System.out.print(tmp.value+" ");
            tmp = tmp.next;
        }
    }
}

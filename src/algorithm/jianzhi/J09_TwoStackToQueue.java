package algorithm.jianzhi;

import java.util.Stack;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/13 下午7:52
 * @Description
 *
 * 面试题9：用两个栈实现一个队列
 */

public class J09_TwoStackToQueue {

    static class MyQueue<T>{

        Stack<T> stack1 = new Stack<T>();//作为输入空间
        Stack<T> stack2 = new Stack<T>();//作为输出空间，输出空间为空则将输入空间导入

        public void appendTail(T element){
            stack1.push(element);
        }

        public T deleteHead(){
            if(stack2.isEmpty()){
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
                if(stack2.isEmpty()){
                    return null;
                }
            }
            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.appendTail(1);
        myQueue.appendTail(2);
        myQueue.appendTail(3);
        System.out.println(myQueue.deleteHead());
        System.out.println(myQueue.deleteHead());
        myQueue.appendTail(4);
        myQueue.appendTail(5);
        System.out.println(myQueue.deleteHead());
        System.out.println(myQueue.deleteHead());
        System.out.println(myQueue.deleteHead());

    }
}

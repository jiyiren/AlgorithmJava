package myarange;

import java.util.LinkedList;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/8/25 上午9:30
 * @Description
 */

public class Test {
    public static void main(String[] args) {
//        stackTest();
        queueTest();
    }

    public static void stackTest() {
        int[] data = {1, 2, 3, 4, 5, 6};
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < data.length; i++) {
            stack.push(data[i]);
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    public static void queueTest(){
        int[] data = {1, 2, 3, 4, 5, 6};
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < data.length; i++) {
            queue.offer(data[i]);
        }
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}

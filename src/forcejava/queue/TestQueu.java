package forcejava.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/8/2 下午7:19
 * @Description
 */

public class TestQueu {

    public static void main(String args[]) {
        Deque<Integer> q = new ArrayDeque<>();    //41921354ns
//        Deque<Integer> q = new LinkedList<>(); // 59667269ns
        long begin = System.nanoTime();
        test(q);
        long end = System.nanoTime();
        System.out.println("took " + (end - begin) + "ns");
        System.out.println(10_000);
    }

    public static void test(Deque<Integer> q) {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 10_000; j++) {
                q.addLast(j);
            }

            for (int j = 0; j < 10_000; j++) {
                q.removeFirst();
            }
        }
    }
}

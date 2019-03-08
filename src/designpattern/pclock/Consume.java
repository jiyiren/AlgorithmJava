package designpattern.pclock;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/7/20 下午10:01
 * @Description
 */

public class Consume extends Thread {
    LinkedList<String> queue;
    ReentrantLock lock;
    Condition notFull;
    Condition notEmpty;

    public Consume(LinkedList<String> queue, ReentrantLock lock, Condition notFull, Condition notEmpty) {
        this.queue = queue;
        this.lock = lock;
        this.notFull = notFull;
        this.notEmpty = notEmpty;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (queue.size() == 0) {
                    sleep(500);
                    continue;
                }
                sleep(3000);
                System.out.println("===== Consume : " + queue.poll());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

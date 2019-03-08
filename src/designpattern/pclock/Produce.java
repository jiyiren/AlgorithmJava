package designpattern.pclock;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/7/20 下午9:47
 * @Description
 */

public class Produce extends Thread {
    LinkedList<String> queue;
    ReentrantLock lock;
    Condition notFull;
    Condition notEmpty;

    public Produce(LinkedList<String> queue, ReentrantLock lock, Condition notFull, Condition notEmpty){
        this.queue = queue;
        this.lock = lock;
        this.notFull = notFull;
        this.notEmpty = notEmpty;
    }

    @Override
    public void run() {
        int count = 0;
        try {
            while (true){
                if (queue.size() == 10){
                    sleep(500);
                    System.out.println("Product : Full");
                    continue;
                }
                sleep(1000);
                count++;
                String data = "Product-"+count;
                System.out.println("Product : "+data);
                queue.offer(data);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

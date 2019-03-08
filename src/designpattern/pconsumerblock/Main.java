package designpattern.pconsumerblock;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/7/20 下午9:39
 * @Description
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
        Thread producer = new Producer(queue);
        Thread consumer = new Consumer(queue);
        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}

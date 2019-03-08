package designpattern.pconsumerblock;

import java.util.concurrent.BlockingQueue;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/7/20 下午9:37
 * @Description
 */

public class Consumer extends Thread{
    private BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                sleep(1500);
                System.out.println("Consume : "+queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

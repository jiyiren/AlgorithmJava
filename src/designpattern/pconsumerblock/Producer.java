package designpattern.pconsumerblock;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/7/20 下午9:30
 * @Description
 */

public class Producer extends Thread{
    private BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int count = 0;
        while (true){
            try {
                sleep(1000);
                count++;
                String data = "Product-"+count;
                System.out.println("Produce : "+data);
                queue.put(data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

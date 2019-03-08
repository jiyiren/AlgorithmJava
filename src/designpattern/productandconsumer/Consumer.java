package designpattern.productandconsumer;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/3/26 上午10:11
 * @Description
 */

public class Consumer implements Runnable {

    private BlockingQueue<PCData> queue;
    private static final int SLEEPTIME = 1000;

    public Consumer(BlockingQueue<PCData> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        System.out.println("start Consumer id :"+Thread.currentThread().getId());
        Random random = new Random();
        try {
            while (true){
                PCData pcData = queue.take();
                if(pcData!=null){
                    int re = pcData.getData()*pcData.getData();
                    System.out.println(MessageFormat.format("{0}*{1}={2}",pcData.getData(),pcData.getData(),re));
                    Thread.sleep(random.nextInt(SLEEPTIME));
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}

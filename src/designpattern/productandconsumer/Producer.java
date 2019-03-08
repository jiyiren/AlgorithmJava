package designpattern.productandconsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/3/26 上午9:44
 * @Description
 *
 * 生产者
 *
 */

public class Producer implements Runnable {
    private volatile boolean isRunning = true;
    private BlockingQueue<PCData> queue;//内存缓存区
    private static AtomicInteger count = new AtomicInteger();//总数 原子操作
    private static final int SLEEPTIME = 1000;

    public Producer(BlockingQueue<PCData> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        PCData pcData = null;
        Random random = new Random();
        System.out.println("start producting id:"+Thread.currentThread().getId());

            try {
                while (isRunning){
                    Thread.sleep(random.nextInt(SLEEPTIME));
                    pcData = new PCData(count.incrementAndGet());
                    System.out.println(pcData+" enter queue");
                    if(!queue.offer(pcData,2, TimeUnit.SECONDS)){
                        System.err.println("Failure to enter queue");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
    }
    public void stop(){
        System.out.println(Thread.currentThread().getId()+" stop");
        isRunning = false;
    }
}

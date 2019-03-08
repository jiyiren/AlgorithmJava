package basic.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/3/29 下午12:02
 * @Description
 */

public class ThreadFour {

    private static int POOL_NUM = 10;     //线程池数量

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i=0;i<POOL_NUM;i++){
            RunnableThread thread = new RunnableThread();
            executorService.execute(thread);
        }
        executorService.shutdown();
    }

    static class RunnableThread implements Runnable
    {
        @Override
        public void run()
        {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("通过线程池方式创建的线程：" + Thread.currentThread().getName() + " ");

        }

    }
}

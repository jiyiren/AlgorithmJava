package basic.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/1 下午2:55
 * @Description
 */

public class CaseOne {


    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(20);

//        Sum sum = new Sum(100000);
//        long start = System.currentTimeMillis();
//        System.out.println("Main Start!");
//        long end = System.currentTimeMillis();
//        System.out.println("Time:"+(end-start));
//        System.out.println("Main End!");
///////////////////////// CountDownLatch  /////////////////////////
        CountDownLatch countDownLatch = new CountDownLatch(4);
        SumCoundDown sumCoundDown=new SumCoundDown(400000,countDownLatch);
        long startt = System.currentTimeMillis();
        System.out.println("Main Start!");
        for(int i=0;i<10;i++){
            executorService.submit(sumCoundDown);
        }
        countDownLatch.await();
        long endd = System.currentTimeMillis();
        System.out.println("Time:"+(endd-startt));
        System.out.println("Main End!");
        executorService.shutdown();

    }

    static class Sum implements Runnable{
        long i;
        Sum(long data){
            i = data;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+" start");
            long sum = 0;
            while (i>0){
                sum += i--;
            }
            System.out.println(Thread.currentThread().getName()+" end:"+sum);

        }
    }

    static class SumCoundDown implements Runnable{
        long i;
        CountDownLatch countDownLatch;
        SumCoundDown(long data,CountDownLatch countDownLatch){
            i = data;
            this.countDownLatch=countDownLatch;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+" start");
            long sum = 0;
            while (i>0){
                sum += i--;
            }
            System.out.println(Thread.currentThread().getName()+" end:"+sum);
            countDownLatch.countDown();
        }
    }

}

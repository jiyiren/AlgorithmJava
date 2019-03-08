package basic.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/22 下午3:55
 * @Description
 */

public class ReMain {

    public static ReentrantLock reentrantLock = new ReentrantLock();
    public static Condition notFull = reentrantLock.newCondition();
    public static Condition notEmpty = reentrantLock.newCondition();
    static int count = 0;

    static class ThreadA extends Thread{
        @Override
        public void run() {
            System.out.println("Enter ThreadA!");
            reentrantLock.lock();
            // 下面的锁写法错误，要在 while 循环中调用 await()
            if (count <= 0){
                try {
                    System.out.println("A: Waiting");
                    notEmpty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    reentrantLock.unlock();
                }
            }

            System.out.println("Outer ThreadA!");
        }
    }

    static class ThreadB extends Thread{
        @Override
        public void run() {
            System.out.println("Enter ThreadB!");
            while (true){
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
//            System.out.println("Outer ThreadB!");
        }
    }

    public static void main(String[] args) {
        ThreadA A = new ThreadA();
        ThreadB B = new ThreadB();
        A.start();
        B.start();
    }
}

package basic.finalobject;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/27 上午10:32
 * @Description
 *
 * 编写一个死锁的例子，如DeadLockThread实现
 *http://www.jb51.net/article/117120.htm
 *
 * 那么要怎么预防死锁呢？下面介绍几个常见方法：
    1、避免一个线程同时获取多个锁；（尽量单锁）
    2、按一致的顺序加锁；(多锁则尽量顺序一致)
    3、尝试使用限时锁，使用lock.tryLock来代替使用内置锁。(获取锁加时间倒计时自动释放)==》用Semaphore.tryAcquire(1, TimeUnit.SECONDS)
 *
 */

public class DeadLockThread implements Runnable{
    boolean flag;
    static Object o1 = new Object();
    static Object o2 = new Object();

    DeadLockThread(boolean flag){
        this.flag = flag;
    }

    @Override
    public void run() {
        if(this.flag){
            // 先获取o1,再锁o2
            synchronized (o1) {
                try {
                    System.out.println("Lock o1");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("Lock o2...");
                }
            }
        }else{
            // 先获取o1,再锁o2
            // 修改的话可以修为顺序一致的，先获取o1锁再获取o2锁
            synchronized (o2) {
                try {
                    System.out.println("Lock o2");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("Lock o1...");
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new DeadLockThread(true));
        Thread t2 = new Thread(new DeadLockThread(false));
        t1.start();
        t2.start();
    }
}

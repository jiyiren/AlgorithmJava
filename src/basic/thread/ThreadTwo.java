package basic.thread;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/3/29 上午10:52
 * @Description
 */

public class ThreadTwo implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" implements Runnable!");
    }

    public static void main(String[] args) {
        Thread threadTwo = new Thread(new ThreadTwo());
        threadTwo.start();
    }
}

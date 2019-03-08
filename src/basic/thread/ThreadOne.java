package basic.thread;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/3/29 上午10:51
 * @Description
 */

public class ThreadOne extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" extends Thread!");
    }

    public static void main(String[] args) {
        ThreadOne threadOne = new ThreadOne();
        threadOne.start();
    }
}

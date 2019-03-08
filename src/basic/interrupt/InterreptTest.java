package basic.interrupt;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/7/21 上午10:46
 * @Description
 */

public class InterreptTest {

    public static void test(){
        while (true){
            if (Thread.currentThread().isInterrupted()){
                System.out.println(Thread.currentThread().isInterrupted());
                System.out.println(Thread.currentThread().isInterrupted());
                Thread.interrupted();
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                test();
            }
        });
        thread.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(2000);
                        System.out.println("====== in ======");
                        thread.interrupt();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}

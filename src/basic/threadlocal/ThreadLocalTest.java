package basic.threadlocal;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/7/27 下午7:59
 * @Description
 */

public class ThreadLocalTest {

    static class TempInt {
        private int i = 0;

        public TempInt(int i) {
            this.i = i;
        }

        public void increase() {
            i++;
        }

        public void setI(int i) {
            this.i = i;
        }

        public int getI(){
            return i;
        }
    }

    static ThreadLocal<String> mStringThreadLocal = new ThreadLocal<>();
    static class ThreadA extends Thread {
        TempInt tempInt = new TempInt(0);

        String content = null;

        public ThreadA(String content) {
            this.content = content;
        }

        @Override
        public void run() {
            System.out.println(currentThread());
            mStringThreadLocal.set(content);
            if (content.equals("haha")) {
                System.out.println("Thread " + mStringThreadLocal.get() + " minus: " + tempInt.getI());
                tempInt.increase();
            } else {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread " + mStringThreadLocal.get() + ": " + tempInt.getI());
        }
    }

    public static void main(String[] args) {
        ThreadA threadA1 = new ThreadA("haha");
        ThreadA threadA = new ThreadA("threadA");
        threadA1.start();
        threadA.start();

    }
}

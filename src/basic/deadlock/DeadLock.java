package basic.deadlock;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/7/27 上午10:32
 * @Description
 */

public class DeadLock {

    static class ThreadA extends Thread{

        Object conditionA;
        Object conditionB;

        ThreadA(Object A, Object B){
            this.conditionA = A;
            this.conditionB = B;
        }

        @Override
        public void run() {
            synchronized (conditionA){
                System.out.println(Thread.currentThread().getName() + " Get A wait B!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (conditionB){
                    System.out.println("OK!");
                }
            }
        }
    }

    static class ThreadB extends Thread{

        Object conditionA;
        Object conditionB;

        ThreadB(Object A, Object B){
            this.conditionA = A;
            this.conditionB = B;
        }

        @Override
        public void run() {
            synchronized (conditionB){
                System.out.println(Thread.currentThread().getName() + " Get B wait A!");
                synchronized (conditionA){
                    System.out.println("OK!");
                }
            }
        }
    }

    public static void main(String[] args) {
        Object A = new Object();
        Object B = new Object();

        ThreadA threadA = new ThreadA(A,B);
        ThreadB threadB = new ThreadB(A,B);
        threadA.start();
        threadB.start();
    }
}

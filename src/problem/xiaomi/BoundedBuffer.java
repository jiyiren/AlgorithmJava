package problem.xiaomi;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/10 下午9:41
 * @Description
 */

public class BoundedBuffer {
    volatile int size = 0;
    BoundedBuffer(int size){
        this.size = size;
    }

    public synchronized void put() throws InterruptedException {
        if(size>0){
            this.wait();
            size++;
            System.out.println(Thread.currentThread().getName()+" "+size);
            this.notify();
        }else{
            //大于o，可直接put
            size++;
            System.out.println(Thread.currentThread().getName()+" "+size);
            this.notify();
        }
    }

    public synchronized void take() throws InterruptedException {
        if(size<=0){
            this.wait();
            size--;
            System.out.println(Thread.currentThread().getName()+" "+size);
            this.notify();
        }else {
            size--;
            System.out.println(Thread.currentThread().getName()+" "+size);
            this.notify();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BoundedBuffer boundedBuffer = new BoundedBuffer(0);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    boundedBuffer.take();
                    Thread.sleep(5000);
                    boundedBuffer.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    boundedBuffer.put();
                    boundedBuffer.put();
                    boundedBuffer.put();
                    boundedBuffer.put();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t2");

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    boundedBuffer.take();
                    Thread.sleep(5000);
                    boundedBuffer.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t3");
        t1.start();
        t2.start();
        t3.start();
    }

}

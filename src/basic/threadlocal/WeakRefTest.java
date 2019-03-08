package basic.threadlocal;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/8/19 下午1:06
 * @Description
 */

public class WeakRefTest {

    static class Product {
        String name;
        private byte[] bb = new byte[10 * 1024];

        Product(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    '}';
        }

        protected void finalize() {
            System.out.println("Finalize:" + name);
        }
    }

       static ReferenceQueue<Product> queue = new ReferenceQueue<>();
    public static void main(String[] args) throws InterruptedException {
        Product A = new Product("A");
        Product B = new Product("B");
        Product C = new Product("C");
        WeakReference<Product> weakA = new WeakReference<Product>(A, queue);
        WeakReference<Product> weakB = new WeakReference<Product>(B, queue);
        WeakReference<Product> weakC = new WeakReference<Product>(C, queue);

        A = null;
//        C = null;
        B = null;
        checkQueue();
        System.gc();
//        Thread.sleep(6000);
        checkQueue();
    }

    public static void checkQueue() {
        if (queue == null) {
            return;
        }
        System.out.println("queue:");
        WeakReference<Product> ref;
        while ((ref = (WeakReference<Product>) queue.poll()) != null) {
            if (ref != null) {
                // 这里只能输出 ref ，因为 ref 里的 Product 已经被回收了，所以不能打印 ref.get().name
                // 而只能输出弱引用对象，弱引用是不会被回收的
                System.out.println(ref);
            }
        }
    }
}

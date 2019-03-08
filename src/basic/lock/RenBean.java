package basic.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/22 下午3:55
 * @Description
 */

public class RenBean {
    final transient ReentrantLock lock = new ReentrantLock();
    public void add(){
        final ReentrantLock lock = this.lock;
    }
}

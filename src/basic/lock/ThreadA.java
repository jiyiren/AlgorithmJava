package basic.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/7/20 下午9:19
 * @Description
 */

public class ThreadA {
    private ReentrantLock notEmpty;

    public ThreadA(ReentrantLock notEmpty) {
        this.notEmpty = notEmpty;
    }

}

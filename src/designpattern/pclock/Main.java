package designpattern.pclock;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/7/20 下午10:05
 * @Description
 */

public class Main {


    public static void main(String[] args) throws InterruptedException {
        LinkedList<String> queue = new LinkedList<>();
        ReentrantLock lock = new ReentrantLock();
        Condition notFull = lock.newCondition();
        Condition notEmpty = lock.newCondition();
        Thread produce = new Produce(queue,lock,notFull,notEmpty);
        Thread consume = new Consume(queue,lock,notFull,notEmpty);
        produce.start();
        consume.start();
        produce.join();
        consume.join();
    }
}

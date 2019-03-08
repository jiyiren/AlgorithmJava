package basic.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/3/29 上午10:54
 * @Description
 */

public class ThreadThree {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        DownloadCallable download = new DownloadCallable(new DownloadFile());
        FutureTask futureTask = new FutureTask<DownloadFile>(download);
        Thread thread = new Thread(futureTask);
        System.out.println(Thread.currentThread().getName());
        thread.start();
        //执行线程后的返回结果
//        DownloadFile downloadFile= (DownloadFile) futureTask.get();
//        System.out.println(downloadFile.getData());

        try {
            DownloadFile dfile = (DownloadFile) futureTask.get(1, TimeUnit.SECONDS);
            System.out.println(dfile.getData());
        } catch (TimeoutException e) {
            System.out.println("Out of Time!");
            futureTask.cancel(true);
            e.printStackTrace();
        }
    }



}

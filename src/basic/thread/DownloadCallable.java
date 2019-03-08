package basic.thread;

import java.util.concurrent.Callable;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/3/29 上午11:04
 * @Description
 */

public class DownloadCallable implements Callable<DownloadFile> {
    private DownloadFile downloadFile;

    public DownloadCallable(DownloadFile downloadFile){
        this.downloadFile=downloadFile;

    }

    @Override
    public DownloadFile call() throws Exception {
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName()+" implements Callable!");
        downloadFile.setData(2);
        return downloadFile;
    }
}

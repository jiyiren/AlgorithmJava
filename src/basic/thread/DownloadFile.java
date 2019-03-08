package basic.thread;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/3/29 上午11:05
 * @Description
 */

public class DownloadFile {

    private volatile int data =100;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}

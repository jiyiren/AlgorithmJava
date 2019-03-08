package basic.designpattern;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/6 下午12:59
 * @Description
 */

public class MainObserver {
    public static void main(String[] args) {
        ServerManager serverManager = new ServerManager();//被观察者，
        AObserver aObserver = new AObserver(serverManager);// 被观察者内部维护一个队列
        BObserver bObserver = new BObserver(serverManager);

        serverManager.setData(2);
        serverManager.deleteObserver(aObserver);
        serverManager.setData(3);
    }
}

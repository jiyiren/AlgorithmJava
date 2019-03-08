package basic.designpattern;

import java.util.Observable;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/6 下午12:54
 * @Description
 *
 * 被观察者
 *
 */

public class ServerManager extends Observable {
    private int data;

    public int getData() {
        return data;
    }

    public void setData(int i) {
        if(this.data!=i){
            this.data = i;
            setChanged();
        }
        notifyObservers();
    }
}

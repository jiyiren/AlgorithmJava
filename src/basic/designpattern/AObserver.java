package basic.designpattern;

import java.util.Observable;
import java.util.Observer;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/6 下午12:56
 * @Description
 *
 * 观察者
 */

public class AObserver implements Observer {

    public AObserver(ServerManager serverManager){
        super();
        serverManager.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("AObserver receive:Data has changed to "+((ServerManager) o).getData());
    }
}

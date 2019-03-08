package basic.designpattern;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/25 下午1:58
 * @Description
 *
 * 饿汉式
 *
 */

public class Singleton {
    private static Singleton singleton = new Singleton();
    private Singleton(){

    }
    public static Singleton getSingleton(){
        return singleton;
    }
}

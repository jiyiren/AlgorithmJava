package basic.designpattern;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/7/27 上午10:44
 * @Description
 *
 * 内部静态类实现单例模式
 *
 */

public class SingletonInnerClass {
    private static class LazyHolder{
        private static final SingletonInnerClass instance = new SingletonInnerClass();
    }

    private SingletonInnerClass(){}

    public static final SingletonInnerClass getInstance(){
        return LazyHolder.instance;
    }

}

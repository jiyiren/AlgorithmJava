package basic.designpattern;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/25 下午2:00
 * @Description
 *
 * 懒汉式
 */

public class SingletonL {
    private static SingletonL singletonL;
    private SingletonL(){

    }
    // 方法一：直接加synchronized,线程安全
//    public static synchronized SingletonL getSingle(){
//        if (singletonL==null){
//            singletonL = new SingletonL();
//        }
//        return singletonL;
//    }

    // 方法二：双重校验锁
    public static SingletonL getSingletonL(){
        // 这个只在singletonL为空时加锁
        if(singletonL==null){
            synchronized (SingletonL.class){
                // 这里是防止有多个线程进入了第一层判断
                if (singletonL==null){
                    singletonL = new SingletonL();
                }
            }
        }
        return singletonL;
    }
}

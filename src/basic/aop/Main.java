package basic.aop;

import java.lang.reflect.Proxy;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/2 下午12:18
 * @Description
 *
 *
 * Hello 是总父类接口；
 * Dog 类是正常类；
 *
 * JDK 动态代理通过切面在 Dog 对象 sayHello 前后加入额外执行语句；
 *
 *  InvocationHandlerImp 实现 InvocationHandler 接口作为封装 sayHello() 执行流程的包装类；
 *
 *  通过 Proxy 调用 InvocationHandlerImp 类，封装为 Hello 类，
 *
 *  这样再调用 Hello.sayHello() 方法时，则所有额外语句也会执行；
 *
 */

public class Main {
    public static void main(String[] args) {
        Hello hello = new Dog();

        InvocationHandlerImp invocationHandlerImp = new InvocationHandlerImp(hello);
        Hello mhello = (Hello) Proxy.newProxyInstance(Hello.class.getClassLoader(),
                new Class[]{Hello.class}, invocationHandlerImp);
        mhello.sayHello();
    }
}

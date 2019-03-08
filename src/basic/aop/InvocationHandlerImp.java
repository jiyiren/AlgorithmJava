package basic.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/2 下午12:13
 * @Description
 *
 */

public class InvocationHandlerImp implements InvocationHandler {

    private Object hello;

    public InvocationHandlerImp(Object hello){
        this.hello = hello;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("Before!");//这是自身封装的方法
        Object returnObject = method.invoke(hello,args);//原实例方法
        System.out.println("After!");//这是自身封装的方法
        return returnObject;
    }
}

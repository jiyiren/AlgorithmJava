package basic.aop;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/2 下午12:12
 * @Description
 */

public class Dog implements Hello {
    @Override
    public void sayHello() {
        System.out.println("Wang,Wang!");
    }
}

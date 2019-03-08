package basic.loadclass;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/4 下午9:36
 * @Description
 */

public class Test {
    static {
        System.out.println("static block!");
    }
    {
        System.out.println("common block!");
    }

    public Test(){
        System.out.println("construct block!");
    }
}

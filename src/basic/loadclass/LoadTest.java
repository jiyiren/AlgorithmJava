package basic.loadclass;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/4 下午9:37
 * @Description
 */

public class LoadTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader classLoader = Test.class.getClassLoader();
//        classLoader.loadClass("basic.loadclass.Test");
        Class test =Class.forName("basic.loadclass.Test");
//        Class test = Class.forName("basic.loadclass.Test", false, classLoader);
        Test mtest = (Test) test.newInstance();
    }
}

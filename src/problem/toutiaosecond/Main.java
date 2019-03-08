package problem.toutiaosecond;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/8/25 上午11:02
 * @Description
 */

public class Main {
    public static void main(String[] args) {
        String line = "5 3 0";
        String ss = "5 3 0";
        System.out.println((int)ss.charAt(1));

        //对String进行split之后的数组的输出
        String[] tt=ss.split(" ");
        for(String s:tt)
        {
            System.out.println(s);
        }
    }
}

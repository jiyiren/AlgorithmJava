package problem.jingdong;

import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/9 下午6:38
 * @Description
 */

public class MainFive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] strings = str.split(" ");
            System.out.println(strings[0]);
            System.out.println(strings[1]);
        }

    }
}

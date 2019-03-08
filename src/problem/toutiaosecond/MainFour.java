package problem.toutiaosecond;

import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/8/25 上午9:25
 * @Description
 */

public class MainFour {
    static int n = 0;
    static int[] data;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            n = sc.nextInt();
            data = new int[n];
            for (int i = 0; i < n; i++) {
                data[i] = sc.nextInt();
            }
        }
        solution();

    }

    public static void solution(){

    }
}

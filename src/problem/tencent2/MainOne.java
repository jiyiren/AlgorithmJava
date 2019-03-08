package problem.tencent2;

import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/8/31 下午8:12
 * @Description
 */

public class MainOne {

    static int k;
    static int a;
    static int x;
    static int b;
    static int y;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            k = sc.nextInt();
            a = sc.nextInt();
            x = sc.nextInt();
            b = sc.nextInt();
            y = sc.nextInt();
            System.out.println(fun());
        }
//        System.out.println(cfun(2, 3));
    }

    public static long fun() {
        long total = 0;
        if (k == 0) {
            return 0;
        }

        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if ((i * a + j * b) == k) {
                    total += (cfun(i,x)*cfun(j,y));
                    total = total % 1000000007;
                }
            }

        }

        return total;
    }

    public static long cfun(int m, int n) {
        long count = 1;
        while (m > 0) {
            count *= n;
//            count %= 1000000007;
            n--;
            m--;
        }
        return count / getNFactorial1(m);
    }

    public static long getNFactorial1(int n) {
        if (n == 0) {
            return 1l;
        }
        long sum = 1l;
        for (int i = 1; i <= n; i++) {
            sum = sum * i;
//            sum = sum * i % 1000000007;
        }
        return sum;
    }
}

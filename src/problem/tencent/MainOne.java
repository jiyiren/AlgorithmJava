package problem.tencent;

import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/5 下午1:35
 * @Description
 */

public class MainOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            long n = sc.nextLong();
            long m = sc.nextLong();

            System.out.println(Sum(n,m));
        }
    }

    public static long Sum(long n,long m){
        return (m*n)/2;
    }
}

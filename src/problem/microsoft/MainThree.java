package problem.microsoft;

import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/2 下午6:56
 * @Description
 */

public class MainThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int count = sc.nextInt();
            for (int i=0;i<count;i++){
                long n = sc.nextLong();
                System.out.println(edgeCount(n));
            }
        }
    }

    public static long edgeCount(long n){
        if(n==0 || n==1){
            return 0;
        }
        long one = n/2;
        long two = n-one;

        return one*two;
    }
}

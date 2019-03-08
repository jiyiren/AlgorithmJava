package problem.microsoft;

import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/5 上午11:25
 * @Description
 */

public class MainFive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int count = sc.nextInt();
            for (int i=0;i<count;i++){
                int n = sc.nextInt();
                System.out.println(getPrime(n));
            }
        }
    }

    public static long getPrime(int n){
        if(n<=0){
            return 0;
        }
        int count = 0;
        long x = 2;
        while (true){
            if(isPrime(x)){
                count++;
                if(count==n){
                    return x;
                }else{
                    x+=2;
                }
            }else{
                x++;
            }
        }
    }

    public static boolean isPrime(long n) {
        long i;
        for (i = 2; i * i <= n; ++i) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}

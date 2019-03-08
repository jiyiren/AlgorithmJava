package problem.microsoft;

import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/2 下午6:56
 * @Description
 */

public class MainOne {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int count = sc.nextInt();
            for (int i=0;i<count;i++){
                long n = sc.nextLong();
                System.out.println(numberOfSeven(n));
            }
        }
    }

    public static int numberOfSeven(long n){
        int count=0;
        while(n!=0){
            if(n%10==7){
                count++;
            }
            n /= 10;
        }
        return count;
    }


}

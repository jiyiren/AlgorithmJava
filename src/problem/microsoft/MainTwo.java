package problem.microsoft;

import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/2 下午6:56
 * @Description
 */

public class MainTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int count = sc.nextInt();
            int[] candy = new int[count];
            for (int i=0;i<count;i++){
                candy[i] = sc.nextInt();
            }
            System.out.println();
        }
    }

   public static String divide(int[] candy,int count){
        int total=0;
       for (int i=0;i<count;i++){
            total += candy[i];
       }
       return null;
   }

//   public static
}

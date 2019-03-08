package problem.wangyi;

import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/3/27 下午6:42
 * @Description
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            System.out.println(getCount(n,k));
        }

    }

    public static int getCount(int n,int k){
        if(k>=n || n<=0){
            return 0;
        }

        int[] preCount = new int[n];
        int count = 0;
        for(int i = k;i<=n;i++){
            for(int j = k;j<=n;j++){
                if(i%j>=k){
                    count++;
                }
            }
        }

        return count;
    }
}

package problem.meituan;

import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/20 下午6:58
 * @Description
 */

public class MainOne {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int N = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();
            int p = sc.nextInt();
            System.out.println(getValue(N,n,m,p));
        }
    }

    public static int getValue(int N,int n,int m,int p){
        long[] A = new long[N+1];
        int[] nm = new int[n*m];
        A[1] = p;

        int max = -1;
        for (int i=1;i<=n;i++){
            for (int j=1;j<=m;j++){
                int index = (i-1)*m+(j-1);
                nm[index] = getGcd(i,j);
                if (max<nm[index]){
                    max = nm[index];
                }
            }
        }

        for (int i=2;i<=max;i++){
            A[i] = (A[i-1]+153)%p;
        }
        int sum = 0;
        for (int i=0;i<n*m;i++){
            sum += A[nm[i]];
        }
        return sum;
    }

    public static int getGcd(int i, int j) {
        int k;
        while ((k=i%j) != 0) {
            i = j;
            j = k;
        }
        return j;
    }
}

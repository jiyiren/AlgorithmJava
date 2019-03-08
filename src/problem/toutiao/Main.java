package problem.toutiao;

import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/3/24 下午7:05
 * @Description
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] data = new int[n];
            for (int i=0;i<n;i++){
                data[i] = sc.nextInt();
            }
            System.out.println(getCountOfPair(n,k,data));
        }

//        int  n = 5;
//        int  k = 2;
//        int[] data = {1,5,3,4,2};
//        System.out.println(getCountOfPair(n,k,data));
    }

    public static int getCountOfPair(int n,int k, int[] data){
        int count=0;
        int[] pair = new int[100000000];
        for(int i =0;i<100000000;i++){
            pair[i]=-1;
        }
        for(int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                int cha = Math.abs(data[j]-data[i]);
                int min = Math.min(data[j],data[i]);
                int max = Math.max(data[j],data[i]);
                if(cha==k && pair[min]<0){
                    pair[min] = max;
                    count++;
                }
            }
        }
        return count;
    }

}

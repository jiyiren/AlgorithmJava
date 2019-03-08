package problem.toutiao;

import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/3/24 下午8:14
 * @Description
 */

public class Jieri {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int N = sc.nextInt();
            int K = sc.nextInt();
            int H = sc.nextInt();
            int[] data = new int[N];
            for(int i=0;i<N;i++){
                data[i] = sc.nextInt();
            }
            System.out.println(getMaxHeight(N,K,H,data));
        }

//        int N = 3;
//        int K = 3;
//        int H = 2;
//        int[] data = {1,3,6};
//        System.out.println(getMaxHeight(N,K,H,data));

    }

    public static int getMaxHeight(int N,int K,int H, int[] data){
        int[][] height=new int[K+1][K+1];
        for(int i=1;i<=K;i++){
            for(int j=0;j<=K;j++){
                height[i][j]=-1;
            }
        }

        for(int i=1;i<=K;i++){
            int m = i-1;
            for(int x = 0;x<=K;x++){
                if(height[m][x]<0){
                    continue;
                }
                for(int j=0;j<N;j++){//N个高度
                    //从每个高度中选择能跳的额，并计算出高度
                    if((data[j]-height[m][x]>=0) && (data[j]-height[m][x]<=H)){
                        height[i][x] = height[m][x]+(data[j]-height[m][x])*2;
                    }
                }
            }
        }
        int max = 0;
        for(int i=0;i<=K;i++){
            if(height[K][i]>max){
                max = height[K][i];
            }
        }

        return max;
    }

}

package problem.nowcoder;

import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/3/23 下午8:12
 * @Description
 */

public class T95 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            for(int i=0;i<n;i++){
                b[i]=sc.nextInt();
            }

            System.out.println(getHappyValue(n, m, a, b));
//            for(int i=0;i<n;i++){
//                System.out.print(a[i]+",");
//            }
//            System.out.println();
//            for(int i=0;i<n;i++){
//                System.out.print(b[i]+",");
//            }
        }
    }

    public static int getHappyValue(int n,int m,int[] a,int[] b){
        int[] happy = new int[n+1]; //最大值
        happy[0]=0;
        for(int i=1;i<=n;i++){
            int minaIndex = getMinAIndex(a,0,i-1);
            int maxbIndex = getMaxBIndex(b,0,i-1);
            if(minaIndex<0){
                happy[i]=happy[i-1];
            }else if(maxbIndex<0){
                if(i%3==0 && (m-a[minaIndex])>0){
                    happy[i]= happy[i-1]+m-a[minaIndex];
                    a[minaIndex]=-1;
                }else{
                    happy[i] = happy[i-1];
                }
            }else{
                int zeng = b[maxbIndex]-a[minaIndex];
                if(i%3 ==0 ){
                    zeng +=m;
                }
                if(zeng>0){
                    happy[i]=happy[i-1]+zeng;
                    a[minaIndex]=-1;
                    b[maxbIndex]=-1;
                }else{
                    happy[i]=happy[i-1];
                }
            }

        }
        return happy[n];
    }

    public static int getMinAIndex(int[] a, int startIndex, int endIndex){
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i=startIndex;i<=endIndex;i++){
            if(a[i]>=0 && a[i]<min){
                min = a[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static int getMaxBIndex(int[] b, int startIndex, int endIndex){
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(int i=startIndex;i<=endIndex;i++){
            if(b[i]>=0 && b[i]>max){
                max = b[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }


}

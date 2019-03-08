package problem.tencent;

import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/5 下午1:36
 * @Description
 */

public class MainThree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] Xi = new int[n];
            int[] Yi = new int[n];
            int[] Zi = new int[m];
            int[] Wi = new int[m];
            for(int i = 0;i<n;i++){
                Xi[i]=sc.nextInt();
                Yi[i]=sc.nextInt();
            }
            for(int i = 0;i<m;i++){
                Zi[i] = sc.nextInt();
                Wi[i] = sc.nextInt();
            }
            System.out.println(maxTask(n,m,Xi,Yi,Zi,Wi));
        }
    }
    public static String maxTask(int n,int m,int[] Xi,int[] Yi,int[] Zi,int[] Wi){

        int count = 0;
        int totalPrice = 0;
        //任务
        for(int i=0;i<m;i++){
            int price = 0;
            int flag = -1;
            //机器
            for(int j=0;j<n;j++){
                if(Zi[i]<=Xi[j] && Wi[i]<=Yi[j]){
                    int p = Zi[i]*200+3*Wi[i];//当前价值
                    if(p>price){
                        price=p;
                        flag = j;
                    }
                }
            }
            if(flag>=0){
                totalPrice += price;
                Xi[flag] -= Zi[flag];
                count++;
            }
        }
        return ""+count+" "+totalPrice;
    }


}

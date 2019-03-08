package problem.nowcoder;

import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/3/23 下午7:14
 * @Description
 */

public class Bank {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();   //总年数
            double[] rate = new double[6]; //利率
            rate[1]=sc.nextDouble();
            rate[2]=sc.nextDouble();
            rate[3]=sc.nextDouble();
            rate[5]=sc.nextDouble();
            double result = getTotal(n,rate);
            System.out.println(String.format("%.5f",result));
        }
    }

    public static double getTotal(int n, double[] rate){

        if(n==1){
            return Math.pow((1+rate[1]),1);
        }

        double[] year = new double[n+1];    //每年最好情况
        year[0]=1;
        year[1] = Math.pow((1+rate[1]),1);  //第一年最好情况

        double simpleYear2 = Math.pow((1+rate[2]),2);
        double simpleYear3 = Math.pow((1+rate[3]),3);
        double simpleYear5 = Math.pow((1+rate[5]),5);


        for(int i=2;i<=n;i++){
            double maxV = 0;
            for(int j = 0;j<i;j++){
                int remainYear = i-j;
                double remainMaxV = 1;
                if(remainYear == 2){
                    remainMaxV = Math.max(year[2],simpleYear2);
                }else if(remainYear == 3){
                    remainMaxV = Math.max(year[3],simpleYear3);
                }else if(remainYear == 5){
                    remainMaxV = Math.max(year[5],simpleYear5);
                }else{
                    remainMaxV = year[remainYear];
                }
                double curV = year[j]*remainMaxV;
                if(maxV<curV){
                    maxV = curV;
                }
            }
            year[i] = maxV;
        }
        return year[n];
    }


}

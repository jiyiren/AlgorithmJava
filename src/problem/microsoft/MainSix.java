package problem.microsoft;

import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/5 下午12:18
 * @Description
 */

public class MainSix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int count = sc.nextInt();
            for (int i=0;i<count;i++){
                int n = sc.nextInt();
                int k = sc.nextInt();
                double[] weight = new double[n];
                double[] price = new double[n];
                for(int j=0;j<n;j++){
                    weight[j] = sc.nextDouble();
                    price[j] = sc.nextDouble();
                }
                double re = getMax(n,k,weight,price);
                System.out.println(String.format("%.2f",re));
            }
        }
    }

    public static double getMax(int n,int k,double[] weight, double[] price){

        double minWeight = 0;
        double maxPrice = 0;
        for(int i=0;i<k;i++){
            double min = 0;
            double max = 0;
            double p = 0;
            int flag = -1;
            for (int j=0;j<n;j++){
                if((price[j]/weight[j])>p){
                    p = price[j]/weight[j];
                    min = weight[j];
                    max = price[j];
                    flag = j;
                }
            }
            minWeight += min;
            maxPrice += max;
            weight[flag]=-1;
            price[flag]=1;
        }

        return maxPrice/minWeight;
    }
}

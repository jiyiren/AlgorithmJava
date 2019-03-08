package problem.nowcoder;

import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/3/24 下午4:44
 * @Description
 */

public class ShuixianFlower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int min = sc.nextInt();
            int max = sc.nextInt();
            flowers(min,max);
        }
    }

    public static void flowers(int min,int max){
        int[] numPow = new int[10];
        for(int i=0;i<10;i++){
            numPow[i]=(int)Math.pow(i,3);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = min ;i<=max;i++){
            int x = i;
            int sum=0;
            while (x>0){
                sum += numPow[x%10];
                x=x/10;
            }
            if(sum==i){
                sb.append(i+" ");
            }
        }
        if(sb!=null&&sb.length()>0){
            System.out.println(sb.subSequence(0,sb.length()-1));
        }else{
            System.out.println("no");
        }
    }

}

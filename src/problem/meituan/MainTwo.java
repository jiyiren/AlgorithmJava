package problem.meituan;

import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/20 下午6:58
 * @Description
 */

public class MainTwo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int count = sc.nextInt();
            for (int i=0;i<count;i++){
                long n = sc.nextLong();
                System.out.println(printBits(n));
            }
        }
    }

    public static long printBits(long k){
        String n = new String(k+"");

        long sum = 0;
        for (int i=1;i<n.length();i++){
            sum+=9*Math.pow(10,i-1)*i;
        }
        int a = n.charAt(0)-'0';
        String m = n.substring(1,n.length());
        if(m.charAt(0)=='0'){
            int i=0;
            for (i=0;i<m.length();i++){
                if(m.charAt(i)!='0'){
                    break;
                }
            }
            if(i>=m.length()-1){
                sum += n.length();
                return sum;
            }
            m = m.substring(i,m.length());
            long re = Long.parseLong(m);
            sum += (re+1)*n.length();
            return sum;
        }else{
            long re = Long.parseLong(m);
            sum += ((a-1)*Math.pow(10,n.length()))+(re+1)*n.length();
            return sum;
        }

    }
}

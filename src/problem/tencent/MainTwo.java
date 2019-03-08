package problem.tencent;

import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/5 下午1:36
 * @Description
 */

public class MainTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            long k = sc.nextLong();
            long A = sc.nextLong();
            long X = sc.nextLong();
            long B = sc.nextLong();
            long Y = sc.nextLong();

            System.out.println(Result(k,A,X,B,Y));
        }
//        System.out.println(myC(0,6));
    }
    // 搭配歌曲长度的，求搭配长度为k的，使用A长和B长的 所有情况

    public static long Result(long k,long A,long X,long B,long Y){
        long result = 0;
        long mod = 1000000007;
        for (int i=0;i<=X;i++){
            long remain = k-(A*i);
            if(remain<0){
                break;
            }else if(remain==0){
                result += myC(i,X);
                break;
            }else{
                if(remain%B == 0){
                    long j = remain/B;
                    if(j<=Y){
                        result += (myC(i,X)*myC(j,Y));
                    }
                }
            }
        }

        return (result%mod);
    }

    public static long A(long up,long bellow)
    {
        long result=1;
        for(long i=up;i>0;i--)
        {
            result*=bellow;
            bellow--;
        }
        return result;
    }
    public static long myC(long up,long below)
    {
        long helf=below/2;
        if(up>helf)
        {
            up=below-up;

        }
        long denominator=A(up,up);
        long numerator=A(up,below);
        return numerator/denominator;

    }

}

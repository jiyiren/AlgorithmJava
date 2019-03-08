package problem.toutiao;

import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/3/24 下午7:47
 * @Description
 */

public class  HanCount {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(getCount(n));
        }
    }

    public static int getCount(int n){
        int[] preVa = new int[n+1];
        int[] sLeng = new int[n+1];
        int[] mLeng = new int[n+1];
        preVa[1] = 0;
        sLeng[1] = 1;
        mLeng[1] = 1;

        for(int i=2;i<=n;i++){
            for(int j = 0;j<i;j++){
                int cursLen1 = sLeng[j]+sLeng[j];
                int cursLen2 = sLeng[j]+mLeng[j];
                if(cursLen1==i){
                    preVa[i] = preVa[j]+1;
                    sLeng[i] = cursLen1;
                    mLeng[i] = sLeng[j];
                    break;
                }else if(cursLen2==i){
                    preVa[i] = preVa[j]+1;
                    sLeng[i] = cursLen2;
                    mLeng[i] = mLeng[j];
                    break;
                }
            }
        }

        return preVa[n];
    }

}

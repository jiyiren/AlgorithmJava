package problem.wangyi;

import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/3/27 下午6:42
 * @Description
 */

public class MainTwo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int x1[] = new int[n+1];
            int y1[] = new int[n+1];
            int x2[] = new int[n+1];
            int y2[] = new int[n+1];
            for(int i=1;i<=n;i++){
                x1[i]=sc.nextInt();
            }
            for(int i=1;i<=n;i++){
                y1[i]=sc.nextInt();
            }
            for(int i=1;i<=n;i++){
                x2[i]=sc.nextInt();
            }
            for(int i=1;i<=n;i++){
                y2[i]=sc.nextInt();
            }

            System.out.println(getRecCount(n,x1,y1,x2,y2));
        }
    }

    public static int getRecCount(int n,int x1[],int y1[],int x2[],int y2[]){
        if(n<2){
            return 1;
        }

        int[] preCount = new int[n+1];//前面覆盖最多数量
        preCount[1]=1;

        //相交的矩形的左下与右上角坐标
        int[] xx1 = new int[n+1];
        int[] xy1 = new int[n+1];
        int[] xx2 = new int[n+1];
        int[] xy2 = new int[n+1];

        //初始化第一个相交矩形
        xx1[1]=x1[1];
        xy1[1]=y1[1];
        xx2[1]=x2[1];
        xy2[1]=y2[1];

        for(int i=2;i<=n;i++){
            for(int j=1;j<i;j++){
                //根据两个矩形中心x和y轴 都小于 两个矩形的x轴边与y轴边长的一半和 则两个矩形相交
                double zhongxa = (xx1[j]+xx2[j])/2.0;
                double zhongya = (xy1[j]+xy2[j])/2.0;
                double zhongxb = (x1[i]+x2[i])/2.0;
                double zhongyb = (y1[i]+y2[i])/2.0;

                double xDis = Math.abs(zhongxb-zhongxa);
                double yDis = Math.abs(zhongyb-zhongya);
                double edgexa = Math.abs(zhongxa-xx1[j]);
                double edgeya = Math.abs(zhongya-xy1[j]);
                double edgexb = Math.abs(zhongxb-x1[i]);
                double edgeyb = Math.abs(zhongyb-y1[i]);
                if(xDis<(edgexa+edgexb)&&yDis<(edgeya+edgeyb)){
                    preCount[i] = preCount[j]+1;
                    //相交的矩形计算出左下角坐标和右上角坐标
                    //......
                    if(x1[i]<xx1[j] && y1[i]<xy1[j] && x2[i]<xx2[j] && y2[j]<xy2[j]){
                        xx1[i]=x1[i];
                        xy1[i]=y1[i];
                        xx2[i]=xx2[j];
                        xy2[i]=xy2[j];
                    }else {
                        xx1[i]=x1[i];
                        xy1[i]=y1[i];
                        xx2[i]=x2[j];
                        xy2[i]=y2[j];
                    }

                }else{
                    preCount[i] = 1;
                    xx1[i]=x1[i];
                    xy1[i]=y1[i];
                    xx2[i]=x2[i];
                    xy2[i]=y2[i];
                }
            }

        }
        return preCount[n];
    }
}

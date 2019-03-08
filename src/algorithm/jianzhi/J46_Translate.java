package algorithm.jianzhi;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/19 下午3:51
 * @Description
 *
 * 面试题46：把数字翻译成字符串
 *  0-25 分别对应a-z
 */

public class J46_Translate {
    /**
     * 动态规划实现
     * f(n) = f(n-1)+G(n,n-1)*f(n-2), G(n,n-1)表示n与n-1构成的数能否满足在10-25之间，满足则为1否则为0
     * @param number
     * @return
     */
    public static int translateCount(int number){
        String numStr = number+"";
        int length = numStr.length();
        int[] fn = new int[length+1];
        fn[0]=1;//因为2的时候需要f(1)+f(0),f(2)应该为2，因此f(0)需要辅助为1
        fn[1]=1;
        int a,b,k;
        for (int i=2;i<=length;i++){
            a = numStr.charAt(i-2)-'0';
            b = numStr.charAt(i-1)-'0';
            k = 10*a+b;
            if(k>=10&&k<=25){
                fn[i] = fn[i-1]+fn[i-2];
            }else {
                fn[i] = fn[i-1];
            }
        }
        return fn[length];
    }

    public static void main(String[] args) {
        System.out.println(translateCount(12258));
    }
}

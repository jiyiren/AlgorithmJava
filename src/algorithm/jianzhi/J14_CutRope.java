package algorithm.jianzhi;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/14 下午3:49
 * @Description
 * 面试题14：剪绳子
 */

public class J14_CutRope {

    /**
     * 动态规划：逐步求出前n-1长的绳子最大值，然后以当前多剪出一段循环与前面最大值乘出值，比较出最大值
     * 时间复杂度：O(n^2): 外层循环逐步逼近n，内层循环计算当前长为i的最大值
     * 空间复杂度：O(n)
     * @param n
     * @return
     */
    public static int cutRope(int n){
        if(n<=1){
            return 0;
        }
        if(n==2){
            return 1;
        }
        int[] fn = new int[n+1];
        fn[0] = 0;
        fn[1] = 1;
        fn[2] = 2;

        int max = 0;
        for(int i=3;i<=n;i++){
            max = 0;
            for (int j=0;j<i;j++){
                int curV = fn[j]*(i-j);
                if(curV>max){
                    max = curV;
                }
            }
            fn[i] = max;
        }
        return fn[n];
    }

    /**
     * 剑指offer书上的解法，书上说明绳子为1时其最大积为0，也就是f(1)*f(0)
     *
     * @param n
     * @return
     */
    public static int cutRopeFromBook(int n){
        if(n<=1){
            return 0;
        }
        if(n==2){
            return 1;
        }
        int[] fn = new int[n+1];
        fn[0] = 0;
        fn[1] = 1;
        fn[2] = 2;
        fn[3] = 3;

        int max = 0;
        for(int i=4;i<=n;i++){
            max = 0;
            // 这里去掉了一半的循环
            for (int j=1;j<=i/2;j++){
                int curV = fn[j]*fn[i-j];
                if(curV>max){
                    max = curV;
                }
            }
            fn[i] = max;
        }
        return fn[n];
    }

    /**
     * 贪心算法：如果n>=5时，尽可能多地剪出长为3的绳子，当剩下的绳子长度为4时，把绳子分为两段长为2的绳子
     * @param n
     * @return
     */
    public static int curRopeGreedy(int n){
        if(n<2){
            return 0;
        }
        if(n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        int timesOf3 = n/3;
        if(n - timesOf3*3 ==1){
            timesOf3 -=1;
        }
        int timesOf2 = (n-timesOf3*3)/2;

        return (int)Math.pow(3,timesOf3)*(int) Math.pow(2,timesOf2);
    }

    public static void main(String[] args) {
        System.out.println(cutRope(8));
        System.out.println(curRopeGreedy(8));
    }
}

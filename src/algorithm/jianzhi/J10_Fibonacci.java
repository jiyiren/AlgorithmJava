package algorithm.jianzhi;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/13 下午8:16
 * @Description
 *
 * 面试题10：斐波那契数列
 */

public class J10_Fibonacci {

    /**
     * 递归实现
     *
     * 时间复杂度O(2^n),空间复杂度O(2^n)
     * 因为求第n个数时，就相当于建立一个n高的树，最顶端为第n数
     * @param n
     * @return
     */
    public static int fibonacci(int n){
        if(n<=0){
            return 0;
        }
        if(n==1){
            return 1;
        }

        return fibonacci(n-1)+fibonacci(n-2);
    }

    /**
     * 非递归斐波那契
     * 时间复杂度O(n)
     * 只需要两个变量记录之前计算好的值就可以了
     * @param n
     * @return
     */
    public static int noRecurseFibonacci(int n){
        if(n<=0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int prepreNum = 0;
        int preNum = 1;
        int curNum = 0;
        int i=2;
        while (i<=n){
            curNum = prepreNum+preNum;
            prepreNum = preNum;
            preNum = curNum;
            i++;
        }
        return curNum;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(10));
        System.out.println(noRecurseFibonacci(10));
    }
}

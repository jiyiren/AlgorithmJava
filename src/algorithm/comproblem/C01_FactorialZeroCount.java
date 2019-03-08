package algorithm.comproblem;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/16 下午7:21
 * @Description
 *
 * 编程之美
 * 给定一个整数n，那么n! 末尾有多少个0呢？如 n=10,n!=3628800,n!的末尾有两个0
 *
 */

public class C01_FactorialZeroCount {

    /**
     *
     * n！中0的个数就是5*2得到的，很明显n!中偶数的个数多于5的个数，因此只要计算有多少个因子5就可以了
     * 第一次 count += n/5 计算出含有1个5因子的个数，n = n/5
     * 第二次 count += n/5 计算出含有2个5因子的个数，n = n/5
     * .
     * .
     * .
     *
     * 这样一直计算到最后，就能得到总的count了。(注：25本身算含有两个5因子，因此有很多个5的循环除5到最后就可以得到所有5因子个数了)
     *
     * @param n
     * @return
     */
    public static int countZero(int n){
        int count = 0;
        while (n > 0){
            count += n/5;
            n /= 5;
        }
        return count;
    }

    /**
     * 计算n!中的二进制位最后一个1的位置
     *
     * 这个问题同上，就是计算最后一位1的移动的位数，由于乘以2代表向左移动一位，因此就是计算n!中2因子的个数
     *
     * 注：是n阶乘而不是n
     * @param n
     * @return
     */
    public static int lowestOne(int n){
        int count = 0;
        while(n>0){
            //第一种方式，同上
//            count += n/2;
//            n /= 2;
            n >>= 1;
            count += n;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countZero(10));//10!
        System.out.println(lowestOne(3));//3!=6, 6为110
        System.out.println(lowestOne(2));//2!=2, 2为 10
    }
}

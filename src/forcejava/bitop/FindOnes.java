package forcejava.bitop;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/8/2 下午4:47
 * @Description
 *
 *
 * 求的是数据在计算机中的表示法，即正数(原码，反码，补码)，负数(补码)
 *
 * 负数原码：最高位为1，剩余位按照正数计算，如：-7 =>原 1..... 0111  => 32位有31位1
 * 负数反码：最高位为1不变，其余位，取反   如：-7 => 反 111111 1000  => 32位有29位1
 * 负数补码（计算机表示法），其反码 +1，   如：-7 => 补 111111 1001  => 32位有30位1
 *
 * 另外，如 -1，其补码为 11111... 1111 , 32位中有32位1，因此计算负数的1的位数是计算补码的位数
 *
 * ============================================================================================================
 *
 * 1. 先看第一道题，一个整数，要求去掉它的二进制表示法的最后一次出现的1，例如， 110，去掉最后一个1就是100。
 * 这个题目使用与来做就会很简单，只用一条语句就可以得到了。
 *
 * 2. 在第一道题的基础上，再看第二题，统计整数转成二进制后总共有多少位是1
 *
 */

public class FindOnes {

    /**
     * 第一题
     * @param a
     * @return
     */
    public static int expellOne(int a) {
        System.out.format( "%x\n", a-1);
        return a & (a-1);
    }

    /**
     * 第二题
     * @param a
     * @return
     */
    public static int calcOnes(int a) {
        int count = 0;
        System.out.format( "%x\n", a);
        while(a != 0) {
            a = expellOne(a);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(calcOnes(-1));
    }
}

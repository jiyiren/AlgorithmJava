package algorithm.jianzhi;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/14 下午9:00
 * @Description
 */

public class J15_NumberOfOne {

    /**
     * 适用于Java和C++，但是只适用正数，复杂度该数中二进制1的个数，时间复杂度最小
     * O(m) m为二进制位1的个数
     * 只能求正数中二进制位的个数
     * @param n
     * @return
     */
    public static int numberOfOne(int n){
        int count = 0;
        while (n>0){
            n = n&(n-1);
            count++;
        }
        return count;
    }

    /**
     *
     * Java和C++都适用，负数正数都适用，但是复杂度为32
     *
     * O(n) 二进制位数
     * 正数和负数均可以实现二进制位个数计数
     * 对于负数的位数计算只能计算补码中1的个数，如-9，源码 0x80000009 , 反码0xfffffff6,补码0xfffffff7,补码为31个二进制位；
     * 通过移动辅助变量，一直到符号位前一位，则负数最后要+1表示符号位的1的个数；
     *
     * @param n
     * @return
     */
    public static int numberOfOne2(int n){
        int count = 0;
        int i=1;
        while (i!=0){
            if((i&n)!=0){//n为负数也可以判断，像((i&n)>0)这种情况只能判断正数n情况，因此本方法较好
                count++;
            }
            i <<=1; //移动32位
        }
        return count;
    }

    /**
     * 适用于Java,可以用于正数和负数,复杂度负数32，正数为该数的有效二进制位数目
     * 但是用到了无符号右移操作，C或C++应该没有此种操作
     * @param n
     * @return
     */
    public static int numberOfOne3(int n){
        int count = 0;
        while(n!=0){
            if((n&1)!=0){
                count++;
            }
            n >>>= 1;//无符号右移,负数最多移动32位，正数则最多移动本身二进制位数
        }
        return count;
    }

    public static void main(String[] args) {
//        int num = -11;
        int num = 11;
        System.out.println(numberOfOne(0xffffffff));
        System.out.println(numberOfOne2(num));
        System.out.println(numberOfOne3(num));
        System.out.println(Integer.bitCount(num));
    }
}

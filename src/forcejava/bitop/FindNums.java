package forcejava.bitop;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/8/2 下午4:22
 * @Description 1. 一个整型数组里除了一个数字之外，其他的数字都出现了两次。请找出这个数字。
 * <p>
 * 我们可以使用异或来解决这个问题，把数组里的所有元素全部进行异或操作。由于异或操作的交换律和结合律我们知道，所有出现了两次的数字，
 * 都与自己先结合进行运算，那么结果就是0，最后，剩下的那个数字就是要找的数字。
 * <p>
 * 2. 题目要求更进一步，如果数组中只出现了一次的数字有两个，而其他数字都出现了两次呢？
 * <p>
 * 思路是，如果能够把原数组分为两个子数组。在每个子数组中，包含一个只出现一次的数字，而其他数字都出现两次。如果能够这样拆分原数组，
 * 按照上一题的办法就可以分别求出这两个只出现一次的数字了。
 * <p>
 * 还是从头到尾依次异或数组中的每一个数字，那么最终得到的结果就是两个只出现一次的数字的异或结果。因为其他数字都出现了两次，
 * 在异或的过程中全部抵消掉了。由于这两个数字不一样，那么这个异或结果肯定不为0，也就是说在这个结果数字的二进制表示中至 少就有一位为1。
 * 我们在结果数字中找到第一个为1的位的位置，记为第 N 位。这两个数字不 同，意味着为1的那个位是相异的。
 * 现在我们以第 N 位是不是 1 为标准把原数组中的数字分成两个子数组，第一个子数组中每个数字的第 N 位都为1，而第二个子数组的每个数字的第 N 位都为0。
 */

public class FindNums {

    /**
     * 一个数组中有两个数字只出现一次，找出这两个数字
     *
     * @param data
     * @param length
     * @return
     */
    public static int findNums(int[] data, int length) {
        int num1 = 0;
        int num2 = 0;

        if (length < 2) {
            return -1;
        }

        // 将数组中所有数字都进行异或，那么成对出现的会抵消掉，最终得到的是两个数字的异或值
        int ansXor = 0;
        for (int i = 0; i < length; i++) {
            ansXor ^= data[i];     // 异或
        }

        // 找到异或值的第一个不为0的位置，那么在该位置，这两个数的位值一定是不一样的，
        // 我们利用该位置分成两组
        int pos = findFirstOne(ansXor);

        // 那么两组中再继续一直异或，得到的就是两个数字了
        for (int i = 0; i < length; i++) {
            if (testBit(data[i], pos)) {
                num1 ^= data[i];
            } else {
                num2 ^= data[i];
            }
        }
        System.out.println(" Two Numbers are " + num1 + " and " + num2);
        return 0;
    }


    /**
     * 取二进制中首个 1 的位置
     *
     * @param value
     * @return
     */
    public static int findFirstOne(int value) {
        int pos = 0;
        while ((value & 1) != 1) {
            value = value >> 1;
            pos++;
        }
        return pos;
    }

    /**
     * 测试某位置是否为 1
     *
     * @param value
     * @param pos
     * @return
     */
    public static boolean testBit(int value, int pos) {
        return ((value >> pos) & 1) != 0;
    }


    public static void main(String[] args) {
//        int[] data = {1,1,5,5,0,6,8,8};
//        findNums(data, data.length);
        int[] data = {1,2,3,4,5,6,7,8};
        findOneThousandNum(data, data.length);
    }

    /**
     * 1-10之内，缺少两个数，找出这两个数
     * @param data
     * @param length
     * @return
     */
    public static int findOneThousandNum(int[] data, int length) {
        int num1 = 0;
        int num2 = 0;

        if (length < 2) {
            return -1;
        }

        int ansXor = 0;
        for (int i = 0; i < length; i++) {
            ansXor ^= data[i];
        }
        for (int i = 1; i <= 10; i++) {
            ansXor ^= i;
        }

        int pos = findFirstOne(ansXor);
        for (int i = 0; i < length; i++) {
            if (testBit(data[i], pos)) {
                num1 ^= data[i];
            } else {
                num2 ^= data[i];
            }
        }
        for (int i = 1; i <= 10; i++) {
            if (testBit(i, pos)) {
                num1 ^= i;
            } else {
                num2 ^= i;
            }
        }

        System.out.println(" Two Numbers are " + num1 + " and " + num2);
        return 0;
    }
}

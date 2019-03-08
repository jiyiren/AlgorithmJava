package algorithm.dynamic;

import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/8/11 下午12:16
 * @Description
 *
 * 动态规划：给定一个值，比如：11，还有三枚硬币，面值为：1，3，5，求如何用最少的硬币数量得到给定的值；
 * 遍历各个值所需最少硬币数量==》贪心啊，迭代到给定值(如：11)就得到了最少硬币数量；
 *
 */

public class DivideCoin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int s = sc.nextInt();
            System.out.println(leastCount(s));
        }
    }

    public static int leastCount(int target) {
        // 用数据结构构造条件
        int[] value = {1, 3, 5};
        // 用数据结构构造结果，应该初始化为最大值，但是可以不用在这里初始化，在之后迭代时先进行赋初值即可
        int[] least = new int[target + 1];
        // 动态规划初始值，利用小问题值不断迭代
        least[0] = 0;
        // 动态规划具体迭代过程
        for (int i = 1; i <= target; i++) {
            least[i] = 0x7fffffff;
            for (int j = 0; j < value.length; j++) {
                if (i - value[j] >= 0 && least[i] > least[i - value[j]]) {
                    least[i] = least[i - value[j]] + 1;
                }
            }
        }
        return least[target];
    }
}

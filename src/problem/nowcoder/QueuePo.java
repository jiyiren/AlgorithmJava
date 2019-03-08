package problem.nowcoder;

import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/8/11 下午8:53
 * @Description
 */

public class QueuePo {
    static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            count = scanner.nextInt();
            testQuee();
        }
    }

    public static void testQuee(){
        int n = 8;
        int[] a = new int[n + 1];

        // 从 k=1 第一个皇后开始摆放
        queueArrange(a, 1, n);
    }


    /**
     *
     * @param a
     * @param k
     * @param n
     */
    public static void queueArrange(int[] a, int k, int n) {
        if (k > n) {
            // 八皇后摆放完毕
            count--;
            if (count > 0){
                return;
            }
            for (int i = 1; i <= n; i++) {
                System.out.print(a[i]);
            }
            System.out.println();
        } else {
            // 八皇后未摆放完毕
            for (int i = 1; i <= n; i++) {
                if (count<=0){
                    return;
                }
                // 当前层，给所有可能的皇后位置，然后判断是否可行,没有冲突才可行，否则不再继续下，转而走其他可能性；
                a[k] = i;
                if (!isConflict(a, k)) {
                    queueArrange(a, k + 1, n);
                }
            }

        }
    }

    /**
     * 是否有冲突
     *
     * @param a 八皇后每行所在位置
     * @param k 当前已经排列好的位置
     * @return
     */
    public static boolean isConflict(int[] a, int k) {
        for (int i = 1; i <= k; i++) {
            for (int j = i + 1; j <= k; j++) {
                if (a[i] == a[j] || Math.abs(a[i] - a[j]) == Math.abs(i - j)) {
                    return true;
                }
            }
        }
        return false;
    }
}

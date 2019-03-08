package myarange;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/8/18 下午2:56
 * @Description #
 * 皇后排列问题
 * 方法：回溯法
 */

public class Eight_Queen {

    static int num = 8;                     // 皇后个数
    static int[] result = new int[num + 1]; // 皇后摆放位置，一维数组，如 result[1] = 7, 表示第一个皇后摆放在第 7 位置上
    static int count = 0;                   // 计数用

    public static void main(String[] args) {
        queenArrange(1);         // 八皇后开始排列，从第一个皇后开始
        System.out.println(count);          // 输出皇后排列总个数
    }

    /**
     * 递归求皇后排列数，结果存在 result 数组中
     * 回溯法：在每一部放置时进行判断是否产生冲突，是则跳过，否则继续判别，一直到最后一个皇后排列完毕
     *
     * @param queenIndex 皇后索引，也就是第几个皇后，皇后都是从 1 开始，而非从 0
     */
    public static void queenArrange(int queenIndex) {
        if (queenIndex > num) {
            // 八皇后摆放完毕，进行输出，数据放在 result 数组中
            for (int i = 1; i <= num; i++) {
                System.out.print("(" + i + "," + result[i] + ")");
            }
            System.out.println();
            count++;
            return;
        } else {
            // 八皇后未摆放完毕，对当前皇后的所有可能进行遍历，遍历完后再进行可行性判别，可行则继续，否则继续下一个值判别
            for (int i = 1; i <= num; i++) {
                // 先设置，才能在 isConflict 中进行判别
                result[queenIndex] = i;
                // 是否产生冲突，这里有两种方法，方法二效率更高
                if (!isConflictTwo(queenIndex)) {
                    // 不产生冲突，继续下一个皇后判别
                    queenArrange(queenIndex + 1);
                }
            }
        }
    }

    /**
     * 可行性判别函数
     *
     * @param queenIndex 当前皇后索引，表示当前和之前的皇后都已排放完毕，因此判别也只能对当前皇后以前的进行判别
     * @return
     */
    public static boolean isConflict(int queenIndex) {
        for (int i = 1; i <= queenIndex; i++) {
            // 从第一个皇后开始，与之后的皇后进行比较是在同一列，或者同一对角线，是则产生冲突
            for (int j = i + 1; j <= queenIndex; j++) {
                if (result[i] == result[j] || Math.abs(result[i] - result[j]) == Math.abs(i - j)) {
                    return true;
                }
            }
        }
        // 否则不产生冲突
        return false;
    }

    /**
     * 可行性判别函数：方法二
     * <p>
     * 此方法只需要判别当前放的位置是否与前面已放置的是否有冲突就可以了，因为能进入到安排这一步的说明之前的不存在冲突；
     *
     * @param queenIndex
     * @return
     */
    public static boolean isConflictTwo(int queenIndex) {
        for (int i = 1; i < queenIndex; i++) {
            if (result[i] == result[queenIndex] || Math.abs(result[i] - result[queenIndex]) == Math.abs(i - queenIndex)) {
                return true;
            }
        }
        return false;
    }
}

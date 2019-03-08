package myarange;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/8/13 下午8:21
 * @Description 算法 tag - [深度搜索]
 * <p>
 * 求字符的全排列(Permutation)
 * 如：输入 “abc”，输出：abc、acb、bac、bca、cab、cba
 */

public class FullArrange {

    // 公共变量区，因为下面写了两个解决方法
    //    static char[] data = {'A', 'B', 'C', 'D'};
    static char[] data = {'A', 'B', 'C'};
    static int length = data.length;
    static int count = 0; // 用于对比回溯法和交换法的区别

    // 回溯法用到的结果保存变量
    static char[] result = new char[length];

    public static void main(String[] args) {
        // 交换法求全排列，不需要额外空间
        // Permutation(0);

        // 回溯法求全排列，与八皇后问题一致，需要额外空间以存储当前决策, 但是理解更方便，更通用
        BackTrackArrange(0);
        System.out.println("Count:" + count);
    }

    /**
     * 回溯法求全排列，假设一个排列用 char[] result 表示，那么从第一个位置开始选择排列，如果与之前的已经安排的数产生冲突则跳过，否则继续
     * <p>
     * 时间复杂度 O(n^2)
     *
     * @param curIndex
     */
    public static void BackTrackArrange(int curIndex) {
        if (curIndex >= length) {
            // 排列完则输出
            System.out.println(String.valueOf(result));
        } else {
            // 对当前位置即 curIndex 位置，进行各种可能情况排列，不冲突则继续，否则退出
            for (int i = 0; i < length; i++) {
                result[curIndex] = data[i];
                // 是否产生冲突，可以有两种检测冲突的方法，但是方法二效率更高
                if (!isConflictTwo(curIndex)) {
                    BackTrackArrange(curIndex + 1);
                }
            }
        }
    }

    /**
     * 检测冲突方法一
     * <p>
     * 检测已经排列好的数列中是否存在冲突
     * <p>
     * 假设 char[] result 截止到 curIndex 时，之前的所有位置都已经排列好了，那么当前的 curIndex 是否可以放在此位置呢？
     * <p>
     * 就需要之前的每一位于下面的所有位置进行比较，只要存在一个产生冲突的就返回冲突；
     *
     * @param curIndex
     * @return
     */
    public static boolean isConflict(int curIndex) {
        for (int i = 0; i <= curIndex; i++) {
            for (int j = i + 1; j <= curIndex; j++) {
                count++;
                if (result[i] == result[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 检测冲突方法二
     * <p>
     * 这里不像上面的方法一，方法一是从第一个开始逐个与后面的进行比较；但是我们知道能进入到此处的说明前面的一定没有冲突，
     * <p>
     * 因此，我们只需要检测当前位置与前面的所有是否存在冲突就可以了，而不用检测所有；
     *
     * @param curIndex
     * @return
     */
    public static boolean isConflictTwo(int curIndex) {
        for (int i = 0; i < curIndex; i++) {
            count++;
            if (result[i] == result[curIndex]) {
                return true;
            }
        }
        return false;
    }


    /**
     * 求字符的全排列--递归
     * <p>
     * 确定第一个位置的字符，然后对之后的字符进行相似操作；
     *
     * @param curIndex 当前位置索引
     */
    public static void Permutation(int curIndex) {
        if (curIndex == length - 1) {
            // 如果当前位置已经到数组最后一位，则输出排列结果
            System.out.println(String.valueOf(data));
        } else {
            // 否则，从当前到最后一位，都将当前位置与以后的每个位置都进行互换
            // 只与当前位置以及之后的位置交换，因此不存在重复交换的
            for (int i = curIndex; i < length; i++) {
                count++;
                // 先交换
                swap(data, curIndex, i);
                Permutation(curIndex + 1);
                // 再交换回来, 不改变原来数组次序
                swap(data, curIndex, i);
            }
        }
    }


    /**
     * 交换两个位置上的数
     *
     * @param data
     * @param curIndex
     * @param i
     */
    public static void swap(char[] data, int curIndex, int i) {
        if (curIndex == i) {
            return;
        }
        char tmp = data[curIndex];
        data[curIndex] = data[i];
        data[i] = tmp;
    }


}

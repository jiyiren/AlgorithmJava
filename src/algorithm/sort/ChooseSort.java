package algorithm.sort;

import utils.MyUtil;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/3/22 上午10:25
 * @Description
 */

public class ChooseSort {
    public static void main(String[] args) {
        int[] data = MyUtil.getIntRandomArray(10, 0, 100);
        MyUtil.printIntArray("Before:", data);
        chooseSort(data, 0, data.length - 1);
        MyUtil.printIntArray("After:", data);
    }

    /**
     * 选择排序：
     * 每次从待排序中选出最小的数，放置在已排序末尾
     * 时间复杂度为O(n^2)，空间复杂度O(1)，不稳定(因为选出最小值的过程会交换数据如：3,4,3,1，将1与3互换了，第一个3就跑到第二个3之后了)
     *
     * @param data
     * @param startIndex
     * @param endIndex
     */
    public static void chooseSort(int[] data, int startIndex, int endIndex) {
        int i, j, minIndex, temp;
        for (i = startIndex; i <= endIndex; i++) {
            minIndex = i;
            for (j = i + 1; j <= endIndex; j++) { //从i之后选择最小值的索引
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                temp = data[minIndex];
                data[minIndex] = data[i];
                data[i] = temp;
            }
        }
    }
}

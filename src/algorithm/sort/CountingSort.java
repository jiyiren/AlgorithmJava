package algorithm.sort;

import utils.MyUtil;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/3/22 下午2:30
 * @Description
 */

public class CountingSort {
    public static void main(String[] args) {
        int[] data = MyUtil.getIntRandomArray(10, 0, 100);
        MyUtil.printIntArray("Before:", data);
        countingSort(data, 100, 0, data.length - 1);
        MyUtil.printIntArray("After:", data);
    }

    /**
     * 计数排序：输入元素小于等于k
     * (计算比当前元素小的个数(包括自己)，唯一确定次元素在数组中的位置)
     * 1. 将数组元素映射到长度为k的数组中，长度为k的数组记录每个数出现的次数。
     * 2. 计算出现在每个元素前(包括自己)总个数，那次元素位置固定
     * 3. 依次将该插入到数组固定位置即可
     * 时间复杂度O(n+k)
     * 空间复杂度O(n+k)
     *
     * @param data
     * @param k          最大上限数值
     * @param startIndex
     * @param endIndex
     */
    public static void countingSort(int[] data, int k, int startIndex, int endIndex) {
        int[] countData = new int[k + 1];
        int[] tempData = new int[endIndex - startIndex + 1];
        int i;
        for (i = startIndex; i <= endIndex; i++) {
            countData[data[i]]++;
        }
        for (i = 1; i <= k; i++) {
            countData[i] += countData[i - 1];
        }
        for (i = endIndex; i >= startIndex; i--) {
            tempData[countData[data[i]] - 1] = data[i];
            countData[data[i]]--;
        }
        for (i = startIndex; i <= endIndex; i++) {
            data[i] = tempData[i];
        }
    }
}

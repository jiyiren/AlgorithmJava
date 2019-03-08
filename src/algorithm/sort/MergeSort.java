package algorithm.sort;

import utils.MyUtil;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/3/22 下午12:43
 * @Description
 */

public class MergeSort {
    public static void main(String[] args) {
        int[] data = MyUtil.getIntRandomArray(10, 0, 100);
//        int[] data = {33,35,39,0,58,97,1,12,37,60};
        MyUtil.printIntArray("Before:", data);
        mergeSort(data, 0, data.length - 1);
        MyUtil.printIntArray("After:", data);
    }

    /**
     * 归并排序：分而治之思想
     * 1. 将n个元素平均分成n/2个元素子序列
     * 2. 分别对两个子序列排序
     * 3. 归并两个已经排好序的序列 即得最终排好序的序列
     * 时间复杂度O(logn),空间复杂度O(n),稳定
     *
     * @param data
     * @param startIndex
     * @param endIndex
     */
    public static void mergeSort(int[] data, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int middleIndex = (startIndex + endIndex) / 2;
        mergeSort(data, startIndex, middleIndex);
        mergeSort(data, middleIndex + 1, endIndex);
        //申请相同大小的内存数组，下标从0开始
        int[] tempData = new int[endIndex - startIndex + 1];
        int m = startIndex;         // 分别从两个数组的起始下标开始
        int n = middleIndex + 1;    // 分别从两个数组的起始下标开始
        int i = 0;                  // 这里是 0 而不是 startIndex, 这是因为我们的 tempData 就是完全新的从0开始的，到最后复制回去的时候得加上
        while (m <= middleIndex && n <= endIndex) {
            if (data[m] > data[n]) {
                tempData[i++] = data[n++];  // 取较小值
            } else {
                tempData[i++] = data[m++];
            }
        }
        // 若其中一个数组到头，还有另外一个数组未到头，则要分别进行判断
        while (m <= middleIndex) {
            tempData[i++] = data[m++];
        }
        while (n <= endIndex) {
            tempData[i++] = data[n++];
        }
        //将temp数组中数据填回原数组中，注意tempData的索引是从0开始
        // 复制回去的时候，原 data 数组下标从 startIndex 开始，而 tempData 则是从0开始
        for (i = startIndex; i <= endIndex; i++) {
            data[i] = tempData[i - startIndex];
        }
    }

//    public static void
}

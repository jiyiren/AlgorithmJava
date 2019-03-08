package algorithm.sort;

import utils.MyUtil;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/3/22 上午10:05
 * @Description
 */

public class InsertSort {
    public static void main(String[] args) {
        int[] data = MyUtil.getIntRandomArray(10, 0, 100);
        MyUtil.printIntArray("Before:", data);
        insertSort(data, 0, data.length - 1);
        MyUtil.printIntArray("After:", data);
    }

    /**
     * 插入排序：
     * 每次从待排序数据中选出一个，插入到前面已经排序好的序列中，比较次数和交换次数都与初始序列有关
     * 时间复杂度O(n^2),空间复杂度O(1),算法是稳定的
     *
     * @param data
     * @param startIndex
     * @param endIndex
     */
    public static void insertSort(int[] data, int startIndex, int endIndex) {
        int i, j, target;
        for (i = startIndex + 1; i <= endIndex; i++) { //从第二个数开始到最后一个数
            target = data[i];   //记录当前值
            j = i;              //从当前索引开始，逐个与target比较，大的后移
            while (j >= startIndex + 1 && target < data[j - 1]) {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = target; //最后确定target位置
        }
    }


}

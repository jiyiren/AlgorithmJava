package algorithm.sort;

import utils.MyUtil;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/3/22 上午9:43
 * @Description
 */

public class BubbleSort {
    public static void main(String[] args) {
        int[] data = MyUtil.getIntRandomArray(10, 0, 100);
        MyUtil.printIntArray("Before:", data);
//        bubbleSort(data, 0, data.length-1);
        BigBubbleSort(data, 0, data.length - 1);
        MyUtil.printIntArray("After:", data);
    }

    /**
     * 大泡冒到后面
     *
     * 和大顶堆相似，都是将最大的数换到结尾
     *
     * @param data
     * @param startIndex
     * @param endIndex
     */
    public static void BigBubbleSort(int[] data, int startIndex, int endIndex) {
        int temp;
        for (int i = endIndex; i >= startIndex; i--) { //此循环从结尾到起始
            for (int j = startIndex; j < i; j++) { //此循环从起始到i，不包括i
                if (data[j] > data[j + 1]) {
                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }


    /**
     * 冒泡排序：
     * 每次两两比较相邻的数据，如果逆序则交换，有两种冒泡方式，一种是把小泡冒到前面，一种是把大泡冒到后面；
     * 比较次数与初始序列无关，交换次数与初始序列有关；
     * 时间复杂度是O(n^2),空间复杂度是O(1),是稳定的排序方式；
     * <p>
     * 小泡冒到前面
     *
     * @param data
     * @param startIndex
     * @param endIndex
     */
    public static void bubbleSort(int[] data, int startIndex, int endIndex) {
        int temp;
        for (int i = startIndex; i <= endIndex; i++) {// 此层循环 从起始到结尾
            for (int j = endIndex; j > i; j--) { //此循环从结尾，到i，不包括i
                if (data[j] < data[j - 1]) {
                    temp = data[j - 1];
                    data[j - 1] = data[j];
                    data[j] = temp;
                }
            }
        }
    }



}

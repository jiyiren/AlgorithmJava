package algorithm.sort;

import utils.MyUtil;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/3/21 下午10:27
 * @Description 快速排序算法
 * 最好       平均         最坏        额外空间     稳定性
 * O(nlogn)   O(nlogn)      O(n^2)      O(logn)     不稳定
 * 空间是因为递归选取分区值(target)
 * 快排的平均时间复杂度为O(NlogN），空间复杂度为O(logN)
 * 最坏情况时间复杂度是O(n^2),空间复杂度为O(n)
 * <p>
 * 空间复杂度为什么为O(logn),因为partition操作中需要有变量维持分区因子，这个变量不能看做temp，因为没有操作能代替此
 * 所以每次partition二分数据即2^x=n,从而 x = logn
 * <p>
 * 注意：Partion中前后比较的一定要用>= 与<= 否则会造成死循环，因为有可能中间三个值都一样，导致>和<都不能进判断语句
 */

public class FastSort {

    public static void main(String[] args) {
//        int[] data= MyUtil.getIntRandomArray(10,0,100);
        int[] data = {77, 32, 39, 49, 43, 58, 58, 45, 74, 73};
        MyUtil.printIntArray("Before:", data);
        fastSort(data,0,data.length-1);
//        fastSortNonPa(data,0,data.length-1);
//        fastSortNonPaDecrease(data, 0, data.length - 1);
        MyUtil.printIntArray("After:", data);
    }

    /**
     * 快速排序递归方式 增序排序
     *
     * @param data       数据数组
     * @param startIndex 起始下标
     * @param endIndex   结尾下标
     */
    public static void fastSort(int[] data, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int middleIndex = partition(data, startIndex, endIndex);
        fastSort(data, startIndex, middleIndex - 1);
        fastSort(data, middleIndex + 1, endIndex);
    }

    /**
     * 分区操作
     *
     * @param data  数据数组
     * @param left  起始下标
     * @param right 结束下标
     * @return
     */
    public static int partition(int[] data, int left, int right) {
        int target = data[left]; //默认选取第一作为分区因子
        int i = left;
        int j = right;
        while (i < j) {
            // 需要先从后来判断，因为第一位是空的，所以要找到比target小的放在首位空位置
            while (i < j && target <= data[j]) {
                j--;
            }
            data[i] = data[j];// 第j位为空了
            while (i < j && target >= data[i]) {
                i++;
            }
            data[j] = data[i];// 第i位为空了
        }
        data[i] = target;
        return i; // i或者j，因为两者相同
    }

    /**
     * 快速排序合并版===》增序排序
     *
     * @param data
     * @param startIndex
     * @param endIndex
     */
    public static void fastSortNonPa(int[] data, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int target = data[startIndex]; //默认选取第一作为分区因子
        int i = startIndex;
        int j = endIndex;
        while (i < j) {
            // 需要先从后来判断，因为第一位是空的，所以要找到比target小的放在首位空位置
            while (i < j && target <= data[j]) {
                j--;
            }
            data[i] = data[j];// 第j位为空了
            while (i < j && target >= data[i]) {
                i++;
            }
            data[j] = data[i];// 第i位为空了
        }
        data[i] = target;
        fastSortNonPa(data, startIndex, i - 1);
        fastSortNonPa(data, i + 1, endIndex);
    }

    /**
     * 快速排序合并版 ===》 降序排序
     *
     * @param data
     * @param startIndex
     * @param endIndex
     */
    public static void fastSortNonPaDecrease(int[] data, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int target = data[startIndex]; //默认选取第一作为分区因子
        int i = startIndex;
        int j = endIndex;
        while (i < j) {
            // 需要先从后来判断，因为第一位是空的，所以要找到比target小的放在首位空位置
            while (i < j && target >= data[j]) {
                j--;
            }
            data[i] = data[j];// 第j位为空了
            while (i < j && target <= data[i]) {
                i++;
            }
            data[j] = data[i];// 第i位为空了
        }
        data[i] = target;
        fastSortNonPaDecrease(data, startIndex, i - 1);
        fastSortNonPaDecrease(data, i + 1, endIndex);
    }

}

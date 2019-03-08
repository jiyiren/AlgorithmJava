package algorithm.sort;

import utils.MyUtil;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/3/22 上午10:46
 * @Description
 */

public class HeapSort {
    public static void main(String[] args) {
        int[] data = MyUtil.getIntRandomArray(10, 0, 100);
        MyUtil.printIntArray("Before:", data);
        heapSort(data, 0, data.length - 1);
        MyUtil.printIntArray("After:", data);
    }

    /**
     * 1. 将待排序数构造成一个大根堆，此时序列的最大值为根结点
     * 2. 将根结点与最后一个元素交换
     * 3. 再将从根到最后一个元素之前的元素维护成一个大根堆，如此往复，最终得到一个递增序列
     * 时间复杂度为O(nlogn),空间复杂度O(1)，不稳定
     * 通常认为交换的temp是可以不用temp交换的，因此常常不计算temp的空间
     * 本堆排序maxRootHeap中还定义了maxIndex变量，此变量也是可以不用设置的，直接通过大小比较进行交换数据即可，这里也只是便于实现
     * 因此堆排序的空间复杂度为O(1)而不是O(logn)
     *
     * @param data
     * @param startIndex
     * @param endIndex
     */
    public static void heapSort(int[] data, int startIndex, int endIndex) {
        int temp;
        for (int i = endIndex; i >= startIndex; i--) {
            maxRootHeap(data, startIndex, i);
            temp = data[startIndex];
            data[startIndex] = data[i];
            data[i] = temp;
        }
    }

    /**
     * 构建大顶堆，递归实现从叶子结点向上分层取最大值
     *
     * startIndex 和 endIndex 分别为堆数组的开始下标和结尾下标
     *
     * 最后构建成的大顶堆的根在 startIndex 上
     *
     * @param data
     * @param startIndex
     * @param endIndex
     */
    public static void maxRootHeap(int[] data, int startIndex, int endIndex) {
        // 根为 startIndex, 左儿子为 startIndex*2+1, 右儿子为 startIndex*2+2, 则左儿子没有就代表已经是叶子节点了
        if (startIndex * 2 + 1 > endIndex) {
            return;//无子儿子节点就返回，因为无须找以此节点为根的最大值了
        }

        // 下面分别对左子树求最大值，右子树求最大值，然后比价出大的值，再和根交换

        maxRootHeap(data, 2 * startIndex + 1, endIndex);//筛选左子树最大值给根
        maxRootHeap(data, 2 * startIndex + 2, endIndex);//筛选右子树最大值给根
        int maxIndex = 2 * startIndex + 1, temp; //默认取左儿子为儿子中的最大值
        //存在两个儿子情况,并且右儿子大于左儿子时，取右儿子索引
        if ((2 * startIndex + 2 <= endIndex) && (data[2 * startIndex + 2] > data[2 * startIndex + 1])) {
            maxIndex = 2 * startIndex + 2;
        }
        //根结点与最大儿子比较，小于儿子则交换
        if (data[startIndex] < data[maxIndex]) {
            temp = data[startIndex];
            data[startIndex] = data[maxIndex];
            data[maxIndex] = temp;
        }
    }

    /**
     * 构建小顶堆，递归实现从叶子结点向上分层取最大值
     *
     * @param data
     * @param startIndex
     * @param endIndex
     */
    public static void minRootHeap(int[] data, int startIndex, int endIndex) {
        if (startIndex * 2 + 1 > endIndex) {
            return;//无子儿子节点就返回，因为无须找以此节点为根的最大值了
        }
        minRootHeap(data, 2 * startIndex + 1, endIndex);//筛选左子树最大值给根
        minRootHeap(data, 2 * startIndex + 2, endIndex);//筛选右子树最大值给根
        int minIndex = 2 * startIndex + 1, temp; //默认取左儿子为儿子中的最大值
        //存在两个儿子情况,并且右儿子大于左儿子时，取右儿子索引
        if ((2 * startIndex + 2 <= endIndex) && (data[2 * startIndex + 2] < data[2 * startIndex + 1])) {
            minIndex = 2 * startIndex + 2;
        }
        //根结点与最大儿子比较，小于儿子则交换
        if (data[startIndex] > data[minIndex]) {
            temp = data[startIndex];
            data[startIndex] = data[minIndex];
            data[minIndex] = temp;
        }

    }

}

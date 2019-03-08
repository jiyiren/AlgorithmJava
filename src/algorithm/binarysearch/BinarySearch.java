package algorithm.binarysearch;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/7/15 下午11:20
 * @Description
 */

public class BinarySearch {


    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target1 = 8;
        System.out.println(binarySearch(data, 0, data.length-1, target1));
        int target2 = 10;
        System.out.println(binarySearch(data, 0, data.length-1, target2));
    }

    /**
     * 二分检索
     *
     * 注意点：左右索引要 middle +- 1, 而不能只选 middle
     *
     * @param data       已经排序的数据
     * @param startIndex 起始索引下标
     * @param endIndex   结束索引下标
     * @param target     目标值
     * @return
     */
    public static int binarySearch(int[] data, int startIndex, int endIndex, int target) {
        int left = startIndex;
        int right = endIndex;
        int middle = 0;

        while (left <= right) {
            middle = (left + right) / 2;
            if (data[middle] == target) {
                return middle;
            } else if (data[middle] > target) {
                right = middle - 1;     // 注意点
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

}

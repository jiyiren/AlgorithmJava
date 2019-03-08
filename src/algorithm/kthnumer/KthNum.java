package algorithm.kthnumer;

import utils.MyUtil;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/7/23 下午11:22
 * @Description
 */

public class KthNum {

    public static void main(String[] args) {
        int[] data = {77, 32, 39, 49, 43, 58, 58, 45, 74, 73};
        MyUtil.printIntArray("Before:", data);
        System.out.println(kthNum(data, 0, data.length-1, 1));
        System.out.println(kthNum(data, 0, data.length-1, 2));
        System.out.println(kthNum(data, 0, data.length-1, 3));
        System.out.println(kthNum(data, 0, data.length-1, 4));
        System.out.println(kthNum(data, 0, data.length-1, 5));
        System.out.println(kthNum(data, 0, data.length-1, 6));
        System.out.println(kthNum(data, 0, data.length-1, 7));
        System.out.println(kthNum(data, 0, data.length-1, 8));
        System.out.println(kthNum(data, 0, data.length-1, 9));
    }

    public static int kthNum(int[] data, int startIndex, int endIndex, int n) {

        if (n > (endIndex - startIndex + 1)) {
            return -1;
        }

        int target_index = 0;

        int left = startIndex;
        int right = endIndex;
        target_index = partition(data, left, right);
        while (target_index + 1 != n) {
            if (target_index + 1>n){
                right = target_index -1;
            }else{
                left = target_index + 1;
            }
            target_index = partition(data, left, right);
        }
        return data[target_index];
    }

    public static int partition(int[] data, int left, int right) {
        int target = data[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && target <= data[j]) {
                j--;
            }
            data[i] = data[j];
            while (i < j && target >= data[i]) {
                i++;
            }
            data[j] = data[i];
        }
        data[i] = target;
        return i;   // return the index of target
    }
}

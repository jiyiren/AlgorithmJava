package problem.exercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/8/18 下午1:48
 * @Description
 */

public class MainTwo {

    static int n = 0;
    static int[] data;
    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            n = sc.nextInt();
            data = new int[n];
            for (int i = 0; i < n; i++) {
                data[i] = sc.nextInt();
            }
//            calMax();
            System.out.println(function(data));
        }
    }

    public static void calMax() {
        SingleCombine(0, new LinkedList<Integer>());
        System.out.println(max);
    }

    public static void SingleCombine(int startIndex, List<Integer> tempList) {
        int tempMax = maxList(tempList);
        if (tempMax > max) {
            max = tempMax;
            if (max == 16685 || max == 20384){
                System.out.println(tempList);
            }
        }
        for (int i = startIndex; i < n; i++) {
            tempList.add(data[i]);
            SingleCombine(i + 1, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static int maxList(List<Integer> temp) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i) < min) {
                min = temp.get(i);
            }
            sum += temp.get(i);
        }
        return min * sum;
    }

    public static int function(int[] arr) {
        int len = arr.length;
        int[] sum = new int[len];
        int ans = 0;
        for (int i = 0; i < len; i++) {
            //右边界
            sum[i] = arr[i];
            for (int j = i+1; j < len; j++) {
                if (arr[j] >= arr[i]) {
                    sum[i] += arr[j];
                } else {
                    break;
                }
            }
            //左边界
            for (int j = i-1; j >= 0;j--) {
                if (arr[j] >= arr[i]) {
                    sum[i] += arr[j];
                } else {
                    break;
                }
            }
            ans = Math.max(ans,sum[i]*arr[i]);
        }
        return ans;
    }
}

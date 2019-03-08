package test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/8/11 下午8:10
 * @Description
 */

public class ComaptorTest {
    public static void main(String[] args) {
        Comparator<Integer> comparator = (a, b) -> {
            return a - b;
        };

        Integer[] data = {3, 6, 1, 2, 8};
        Arrays.sort(data, comparator);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }
}

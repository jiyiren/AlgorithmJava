package problem.wangyi;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/3/27 下午6:43
 * @Description
 *
 *
 * input:
 * 5 堆
 * 2， 7， 3， 4， 9
 *
 * output:
 * 3
 * 1， 25， 11
 *
 */

public class MainFour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] data = new int[n];
            for (int i = 0; i < n; i++) {
                data[i] = sc.nextInt();
            }

            int m = sc.nextInt();
            int[] mm = new int[m];
            for (int i = 0; i < m; i++) {
                mm[i] = sc.nextInt();
            }
            ask(n, data, m, mm);
        }
    }

    public static void ask(int n, int[] data, int m, int[] mm) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(mm[i], 0);
        }

        Arrays.sort(mm);
        int flag = 0;
        int sum = data[0];

        int i = 0;
        while (i < n && flag < m) {
            if (mm[flag] <= sum) {
                map.put(mm[flag], i + 1);
                flag++;
            } else {
                i++;
                if (i<n){
                    sum += data[i];
                }
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }

    }
}

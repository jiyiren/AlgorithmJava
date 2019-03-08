package problem.toutiao;

import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/8/12 上午9:49
 * @Description
 */

public class MainOne {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] arr = str.split(",");
            int m = Integer.parseInt(arr[0]);
            int n = Integer.parseInt(arr[1]);
            int[][] data = new int[m][n];
            for (int i = 0; i < m; i++) {
                String line = scanner.nextLine();
                String[] linearr = line.split(",");
                for (int j = 0; j < n; j++) {
                    data[i][j] = Integer.parseInt(linearr[j]);
                }
            }
            get(m, n, data, 0, 0);

        }
    }

    static int p = 0;
    static int q = 0;

    public static void get(int m, int n, int[][] data, int i, int j) {
        if (i >= 0 && i < m && j >= 0 && j < n) {
            if (data[i][j]==1){

            }
        }
        return;
    }


}

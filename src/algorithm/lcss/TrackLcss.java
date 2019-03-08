package algorithm.lcss;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/7/28 上午11:41
 * @Description
 */

public class TrackLcss {

    public static double lcss(String[] A, String[] B) {
        double e = 0.01;
        double o = 20;
        int m = A.length / 2;
        int n = A.length / 2;
        int[][] c = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.abs(Double.valueOf(A[i * 2]) - Double.valueOf(B[j * 2])) <= o
                        && Math.abs(Double.valueOf(A[i * 2 + 1]) - Double.valueOf(j * 2 + 1)) <= o
                        && Math.abs(i - j) < e) {
                    c[i + 1][j + 1] = c[i][j] + 1; //左上角 +1
                } else {
                    c[i + 1][j + 1] = Math.max(c[i][j + 1], c[i + 1][j]);
                }
            }
        }

        return (c[m][n] * 2.0) / (m + n);
    }
}

package algorithm.lcss;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/7/28 上午11:53
 * @Description
 */

public class StringLcss {

    /**
     * 非递归实现
     *
     * @param X
     * @param Y
     * @return
     */
    public static int LCSS(char[] X, char[] Y) {
        int m = X.length;
        int n = Y.length;
        int c[][] = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (X[i] == Y[j]) {
                    c[i + 1][j + 1] = c[i][j] + 1;//要加1呀
                } else {
                    c[i + 1][j + 1] = Math.max(c[i][j + 1], c[i + 1][j]);
                }
            }
        }
        return c[m][n];
    }

    public static void main(String[] args) {
        char[] X = {'A', 'B', 'C', 'B', 'D', 'A', 'B'};
        char[] Y = {'B', 'D', 'C', 'A', 'B', 'A'};
        System.out.println(LCSS(X, Y));
        System.out.println(LCSS_Recursive(X, Y, X.length, Y.length, 0, 0));
    }


    /**
     * 最长公共子序列/递归代码
     * @param X         第一个字符数组/也可以直接用 String 使用 String.charAt() 访问
     * @param Y         第二个字符数组/也可以直接用 String 使用 String.charAt() 访问
     * @param xLength   第一个字符数组长度/这个主要是为了适应 C 等语言不能直接获取数组长度
     * @param yLength   第二个字符数组长度/这个主要是为了适应 C 等语言不能直接获取数组长度
     * @param xIndex    第一个字符数组的索引(也就是下标)
     * @param yIndex    第二个字符数组的索引(也就是下标)
     * @return
     */
    public static int LCSS_Recursive(char[] X, char[] Y, int xLength, int yLength, int xIndex, int yIndex) {
        if (xIndex >= xLength || yIndex >= yLength) {
            return 0;
        }
        if (X[xIndex] == Y[yIndex]) {
            return 1 + LCSS_Recursive(X, Y, xLength, yLength, xIndex + 1, yIndex + 1);
        } else {
            return Math.max(LCSS_Recursive(X, Y, xLength, yLength, xIndex, yIndex + 1), LCSS_Recursive(X, Y, xLength, yLength, xIndex + 1, yIndex));
        }
    }
}

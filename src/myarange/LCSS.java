package myarange;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/8/13 下午2:45
 * @Description 算法 tag - [动态规划]
 *
 * 求字符的最长公共子序列，而不是最长公共子串
 */

public class LCSS {
    // 第一个字符数组/也可以直接用 String 使用 String.charAt() 访问
    static char[] X = {'A', 'B', 'C', 'B', 'D', 'A', 'B'};
    // 第二个字符数组/也可以直接用 String 使用 String.charAt() 访问
    static char[] Y = {'B', 'D', 'C', 'A', 'B', 'A'};

    static int xLength = X.length;
    static int yLength = Y.length;

    public static void main(String[] args) {
        System.out.println("递归实现：");
        System.out.println(LCSS_Recursive(0, 0));
        System.out.println("非递归实现：");
        System.out.println(LCSS_NonRecursive());
    }

    /**
     * /////////////////////////////////////////////////////////////////////////////////////////////////
     * /////////////////////////////////////////// LCSS(递归) //////////////////////////////////////////
     * /////////////////////////////////////////////////////////////////////////////////////////////////
     */

    /**
     * 最长公共子序列--递归代码
     *
     * @param xIndex 第一个字符数组的索引(也就是下标)
     * @param yIndex 第二个字符数组的索引(也就是下标)
     * @return
     */
    public static int LCSS_Recursive(int xIndex, int yIndex) {
        if (xIndex >= xLength || yIndex >= yLength) {
            return 0;
        }
        if (X[xIndex] == Y[yIndex]) {
            return 1 + LCSS_Recursive(xIndex + 1, yIndex + 1);
        } else {
            return Math.max(LCSS_Recursive(xIndex, yIndex + 1), LCSS_Recursive(xIndex + 1, yIndex));
        }
    }

    /**
     * /////////////////////////////////////////////////////////////////////////////////////////////////
     * /////////////////////////////////////////// LCSS(非递归) /////////////////////////////////////////
     * /////////////////////////////////////////////////////////////////////////////////////////////////
     */

    /**
     * 最长公共子序列--非递归代码
     *
     * 从初始位置不断计算，
     *
     * 若：前位置如果相等，则当前数目 = 前一个数目+1
     * 若：当前位不等，则当前数目 = Max( 左侧数目 , 右侧数目 )
     *
     * @return
     */
    public static int LCSS_NonRecursive() {
        int c[][] = new int[xLength + 1][yLength + 1];
        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                if (X[i] == Y[j]) {
                    c[i + 1][j + 1] = c[i][j] + 1;//要加1呀
                } else {
                    c[i + 1][j + 1] = Math.max(c[i][j + 1], c[i + 1][j]);
                }
            }
        }
        return c[xLength][yLength];
    }


}

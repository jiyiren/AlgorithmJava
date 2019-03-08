package algorithm.comproblem;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/18 下午10:59
 * @Description
 */

public class C02_LCSS {

    public static int LCSS(char[] x,char[] y){
        if(x==null || y==null){
            return 0;
        }
        return LCSSRe(x,y,0,0);
    }

    /**
     * 相似轨迹递归实现
     * @param x
     * @param y
     * @param xIndex
     * @param yIndex
     * @return
     */
    public static int LCSSRe(char[] x, char[] y, int xIndex,int yIndex){
        if(xIndex>=x.length || yIndex>=y.length){
            return 0;
        }
        if(x[xIndex]==y[yIndex]){
            return 1+LCSSRe(x,y,xIndex+1,yIndex+1);
        }else {
            return Math.max(LCSSRe(x,y,xIndex+1,yIndex),LCSSRe(x,y,xIndex,yIndex+1));
        }
    }



    public static void main(String[] args) {
        String x = "ABCBDAB";
        String y = "BDCABA";
        System.out.println(LCSS(x.toCharArray(),y.toCharArray()));
        System.out.println(DyLCSS(x.toCharArray(),y.toCharArray()));
    }

    /**
     * 相似轨迹动态规划
     * @param x
     * @param y
     * @return
     */
    public static int DyLCSS(char[] x,char[] y){
        if(x==null||y==null){
            return 0;
        }
        int m = x.length;
        int n = y.length;
        int[][] c = new int[m+1][n+1];

        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if(x[i-1]==y[j-1]){
                    c[i][j]=c[i-1][j-1]+1;
                }else if(c[i-1][j]>c[i][j-1]){
                    c[i][j]=c[i-1][j];
                }else {
                    c[i][j]=c[i][j-1];
                }
            }
        }
        return c[m][n];
    }
}

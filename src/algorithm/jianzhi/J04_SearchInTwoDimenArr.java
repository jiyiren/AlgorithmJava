package algorithm.jianzhi;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/13 下午2:27
 * @Description
 *
 * 二维数组中的查找
 */

public class J04_SearchInTwoDimenArr {

    /**
     * 从右上角查起，如果等于则返回true,如果> target 则列号--，如果<target 则行号++
     * 时间复杂度O(n+m),n为行数，m为列数
     * 空间复杂度O(1)
     *
     * 思考：为什么从右上角开始搜索呢，就是因为 横折 看二维数组实际上右上角是一个中间值，也就相当于二分查找
     *
     * @param data
     * @param rows
     * @param columns
     * @param target
     * @return
     */
    public static boolean searchInTwoDimenArr(int[][] data,int rows,int columns,int target){
        if(data==null){
            return false;
        }
        int i = 0,j = columns-1;
        while (i<rows && j>=0){
            if(data[i][j]==target){
                return true;
            }else if(data[i][j] <target){
                i++;
            }else{
                // data[i][j] > target
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] data = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(searchInTwoDimenArr(data,4,4,7));
        System.out.println(searchInTwoDimenArr(data,4,4,22));
    }


}

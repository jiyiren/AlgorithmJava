package algorithm.jianzhi;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/14 下午3:18
 * @Description
 *
 * 面试题13：机器人的运动范围
 *
 */

public class J13_MovingCount {

    /**
     * 从(0,0)开始，计算可移动的格子数目
     * @param rows
     * @param columns
     * @param threshold
     * @return
     */
    public static int movingCount(int rows,int columns,int threshold){
        if(threshold<0 || rows<=0 || columns<=0){
            return 0;
        }
        int[][] visited = new int[rows][columns];
        return calculateCount(visited,rows,columns,0,0,threshold);
    }

    /**
     * 递归计算可以访问的格子
     * @param visited
     * @param rows
     * @param columns
     * @param rowIndex
     * @param columnIndex
     * @param threshold
     * @return
     */
    public static int calculateCount(int[][] visited,int rows,int columns,int rowIndex,int columnIndex,int threshold){
        if(rowIndex<0 || rowIndex>=rows || columnIndex<0 || columnIndex>=columns){
            return 0;
        }
        if(visited[rowIndex][columnIndex]==0 && check(rowIndex,columnIndex,threshold)){
            visited[rowIndex][columnIndex] =1;
            return 1+calculateCount(visited,rows,columns,rowIndex+1,columnIndex,threshold) +
                    calculateCount(visited,rows,columns,rowIndex-1,columnIndex,threshold) +
                    calculateCount(visited,rows,columns,rowIndex,columnIndex+1,threshold) +
                    calculateCount(visited,rows,columns,rowIndex,columnIndex-1,threshold);
        }else{
            return 0;
        }
    }


    /**
     * 检查当前坐标各个位数之和是否小于等于阈值
     * @param rowIndex
     * @param columnIndex
     * @param threshold
     * @return
     */
    public static boolean check(int rowIndex,int columnIndex,int threshold){
        int sum = digitalSum(rowIndex)+digitalSum(columnIndex);
        return sum>threshold ? false:true;
    }

    /**
     * 计算各个位数之和
     * @param number
     * @return
     */
    public static int digitalSum(int number){
        int sum = 0;
        while (number>0){
            sum+=number%10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(40,40,3));
    }
}

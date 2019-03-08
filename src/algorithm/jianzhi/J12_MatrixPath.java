package algorithm.jianzhi;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/14 下午12:19
 * @Description
 */

public class J12_MatrixPath {

    /**
     * 判断字符矩阵中是否存在某一个连续字符路径，相邻字符只能在上下左右
     * @param matrix
     * @param rows
     * @param columns
     * @param str
     * @return
     */
    public static boolean matrixPath(char[][] matrix,int rows,int columns,String str){
        if(matrix==null || rows<1 || columns<1 || str==null){
            return false;
        }
        int[][] visited = new int[rows][columns];

        // 遍历所有字符，在canAchieve中会判断是否与字符串匹配
        for (int i=0;i<rows;i++){
            for (int j=0;j<columns;j++){
                if(canAchieve(matrix,visited,rows,columns,i,j,str,0)){
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 递归判断是否可以找到，采用回溯法，需要访问标识
     * @param matrix
     * @param visited
     * @param rowIndex
     * @param columnIndex
     * @param str
     * @param strIndex
     * @return
     */
    public static boolean canAchieve(char[][] matrix,int[][] visited,int rows,int columns,
                                     int rowIndex,int columnIndex,String str,int strIndex){
        if(rowIndex<0 || rowIndex>=rows || columnIndex<0 || columnIndex>=columns || strIndex>=str.length()){
            return false;
        }
        //  成功的结束条件：当前为字符串最后一位字符，且该字符和该矩阵位置上的字符相同，且该位置未被访问过
        if(visited[rowIndex][columnIndex]==0 && matrix[rowIndex][columnIndex] == str.charAt(strIndex)
                && strIndex==(str.length()-1)){
            return true;
        }
        // 递归条件：当前还不是字符串最后一位字符，且当前位置的字符和当前矩阵位置上的字符相同，则搜索该字符串四周，且将该字符置为1(访问过了)
        if(visited[rowIndex][columnIndex]==0 && matrix[rowIndex][columnIndex]==str.charAt(strIndex)){
            visited[rowIndex][columnIndex]=1;//对在字符串内的访问过的就加标记
            return canAchieve(matrix,visited,rows,columns,rowIndex+1,columnIndex,str,strIndex+1) ||
                    canAchieve(matrix,visited,rows,columns,rowIndex-1,columnIndex,str,strIndex+1) ||
                    canAchieve(matrix,visited,rows,columns,rowIndex,columnIndex+1,str,strIndex+1) ||
                    canAchieve(matrix,visited,rows,columns,rowIndex,columnIndex-1,str,strIndex+1);
        }else{
            // 否则 只要当前矩阵位置被访问过或者当前位置字符和字符串中的字符不相同则，返回false
            return false;
        }
    }

    public static void main(String[] args) {
        char[][] matrix = {{'a','b','t','g'},{'c','f','c','s'},{'j','d','e','h'}};
        int rows = 3;
        int columns = 4;
        String str = "bfce";
//        String str = "abfb";
        System.out.println(matrixPath(matrix,rows,columns,str));
    }
}

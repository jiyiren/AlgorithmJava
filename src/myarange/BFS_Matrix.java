package myarange;

import java.util.LinkedList;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/8/13 下午6:53
 * @Description 算法 tag - [广度搜索]
 *
 * 如下一个矩阵，其中为1的代表有个体存在，我们认定有个体存在且附近可关联的所有个体，作为一个群组，附近指上、下、左、右、对角；
 * 求群体的个数，以及各个群体中个体的数目
 *
 * 10行, 10列
 * ===0 1 2 3 4 5 6 7 8 9
 * 0  0,0,0,0,0,0,0,0,0,0
 * 1  0,0,0,1,1,0,1,0,0,0
 * 2  0,1,0,0,0,0,0,1,0,1
 * 3  1,0,0,0,0,0,0,0,1,1
 * 4  0,0,0,1,1,1,0,0,0,1
 * 5  0,0,0,0,0,0,1,0,1,1
 * 6  0,1,1,0,0,0,0,0,0,0
 * 7  0,0,0,1,0,1,0,0,0,0
 * 8  0,0,1,0,0,1,0,0,0,0
 * 9  0,1,0,0,0,0,0,0,0,0
 */

public class BFS_Matrix {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int xLength = 10;
    static int yLength = 10;
    static int[][] matrix = new int[xLength][yLength];
    static int[][] isgone = new int[xLength][yLength];
    static int count = 0;

    public static void main(String[] args) {
        matrix[1][3] = matrix[1][4] = matrix[1][6] = 1;
        matrix[2][1] = matrix[2][7] = matrix[2][9] = 1;
        matrix[3][0] = matrix[3][8] = matrix[3][9] = 1;
        matrix[4][3] = matrix[4][4] = matrix[4][5] = matrix[4][9] = 1;
        matrix[5][6] = matrix[5][8] = matrix[5][9] = 1;
        matrix[6][1] = matrix[6][2] = 1;
        matrix[7][3] = matrix[7][5] = 1;
        matrix[8][2] = matrix[8][5] = 1;
        matrix[9][1] = 1;

        BFS_NoeRecursive_Main();
    }

    /**
     * 对矩阵中各个未访问过的点进行尝试访问
     */
    public static void BFS_NoeRecursive_Main() {
        LinkedList<Point> queue = new LinkedList<>();
        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                if (matrix[i][j] == 1 && isgone[i][j] == 0) {
                    count++;
                    System.out.println("\n第 " + count + " 个团簇:");
                    queue.clear();
                    queue.offer(new Point(i, j));
                    BFS_NoeRecursive(queue);
                }
            }
        }
    }

    /**
     * 根据点的周围关系 => 进行加入队列访问
     * @param queue
     */
    public static void BFS_NoeRecursive(LinkedList<Point> queue) {
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            // 需要先判断是否已经访问过，因为，有的已经加入的点可能加入了多次，因此需要判断；
            if (isgone[p.x][p.y] == 0){
                System.out.print("(" + p.x + "," + p.y + ") ");
                isgone[p.x][p.y] = 1;
            }else{
                continue;
            }
            // 将该点附近各个符合的点都加入到队列中，注意一定是要合法且未访问过的
            for (int m = p.x - 1; m <= p.x + 1; m++) {
                for (int n = p.y - 1; n <= p.y + 1; n++) {
                    if (m < 0 || m >= xLength || n < 0 || n >= yLength || matrix[m][n] == 0 || isgone[m][n] == 1) {
                        continue;
                    } else {
                        queue.offer(new Point(m, n));
                    }

                }
            }
        }
    }

}

package myarange;

import java.util.LinkedList;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/8/13 下午7:43
 * @Description 算法 tag - [深度搜索]
 *
 * 图遍历
 * <p>
 * 示例图结构, 非连通图：
 * 0 - 5 - 6 - 4
 * | \
 * 2 3
 * |
 * 1
 * <p>
 * 7
 */

public class DFS_Graph {
    // 图的顶点总个数
    static int pointCount = 8;
    static int[][] graph = new int[pointCount][pointCount];
    static int[] isgone = new int[pointCount];

    static int count = 0;

    public static void main(String[] args) {

        graph[0][2] = graph[0][3] = graph[0][5] = 1;
        graph[1][2] = 1;
        graph[2][0] = graph[2][1] = 1;
        graph[3][0] = 1;
        graph[4][6] = 1;
        graph[5][0] = graph[5][6] = 1;
        graph[6][4] = graph[6][5] = 1;

        // 递归实现深度优先搜索
        System.out.println("递归访问：");    // 0,2,1,3,5,6,4,7
        // DFS_Recursive_main();
        // 非递归实现深度优先搜索
        System.out.println("非递归访问：");   // 0,5,6,4,3,2,1,7
        DFS_NonRecursive();
    }

    /**
     * /////////////////////////////////////////////////////////////////////////////////////////////////
     * //////////////////////////////////////// 深度遍历(递归) /////////////////////////////////////////
     * /////////////////////////////////////////////////////////////////////////////////////////////////
     */

    /**
     * 非连通图的深度优先搜索--入口函数
     */
    public static void DFS_Recursive_main() {
        // 循环从各个点入口开始访问(如果是连通图，则只需要从一个点入口就可以了，
        // 而对于非连通图，则有可能存在孤立的点，因此需要各个点都尝试走一遍)
        for (int i = 0; i < pointCount; i++) {
            DFS_Recursive(i);
        }
        System.out.println("Total Running Count:" + count);
    }

    /**
     * 非连通图的深度优先搜索--递归实现
     *
     * @param curPoint 当前结点索引
     */
    private static void DFS_Recursive(int curPoint) {
        // 如果当前结点被访问过，则退出(这个判断是为了起始点的访问的，
        // 因为下面循环里面有 isgone 的判断，所以在递归过程中下面的判断不成立的)
        if (isgone[curPoint] > 0) {
            return;
        }
        // 否则访问，并标识已访问
        System.out.println(curPoint);
        isgone[curPoint] = 1;
        // 对当前结点的所有临接点进行访问
        for (int i = 0; i < pointCount; i++) {
            count++;
            // 是临接点，并且没被访问过，则访问
            if (graph[curPoint][i] > 0 && isgone[i] == 0) {
                DFS_Recursive(i);
            }
        }
    }

    /**
     * /////////////////////////////////////////////////////////////////////////////////////////////////
     * //////////////////////////////////////// 深度遍历(非递归) /////////////////////////////////////////
     * /////////////////////////////////////////////////////////////////////////////////////////////////
     */

    /**
     * 非连通图的深度优先搜索--非递归实现
     */
    public static void DFS_NonRecursive() {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < pointCount; i++) {
            if (isgone[i] == 0) {
                stack.push(i);
            }
            while (!stack.isEmpty()) {
                int p = stack.pop();
                if (isgone[p] == 1) {
                    continue;
                }
                System.out.println(p);
                isgone[p] = 1;
                for (int j = 0; j < pointCount; j++) {
                    if (graph[p][j] == 1 && isgone[j] == 0) {
                        stack.push(j);
                    }
                }
            }
        }
    }
}

package algorithm.dfsbdfs;

import java.util.LinkedList;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/8/11 下午12:19
 * @Description
 */

public class GraphDFS {

    public static class TestCount {
        int value;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            int points = sc.nextInt();
//            int[][] graph = new int[points][];
//        }
        // 图的顶点总个数
        int pointCount = 8;
        // 图的各个顶点是否访问过，初始化为0
        int[] isgone = new int[pointCount];
        for (int i = 0; i < pointCount; i++) {
            isgone[i] = 0;
        }
        // 图的各条边，用邻接矩阵表示
        int[][] graph = new int[pointCount][pointCount];
        for (int i = 0; i < pointCount; i++) {
            for (int j = 0; j < pointCount; j++) {
                graph[i][j] = 0;
            }
        }
        /**
         * 示例图结构：
         * 0 - 5 - 6 - 4
         * | \
         * 2 3
         * |
         * 1
         */
        graph[0][2] = 1;
        graph[0][3] = 1;
        graph[0][5] = 1;
        graph[1][2] = 1;
        graph[2][0] = 1;
        graph[2][1] = 1;
        graph[3][0] = 1;
        graph[4][6] = 1;
        graph[5][0] = 1;
        graph[5][6] = 1;
        graph[6][4] = 1;
        graph[6][5] = 1;

        // 递归实现深度优先搜索
//        recurGraphDfs(pointCount, graph, isgone);
        // 非递归实现深度优先搜索
        graphNoRecurDfs(pointCount, graph, isgone);
    }

    /**
     * 递归实现深度优先搜索
     *
     * @param pointCount
     * @param graph
     * @param isgone
     */
    public static void recurGraphDfs(int pointCount, int[][] graph, int[] isgone) {
        // 测试运行中比较总次数
        TestCount testCount = new TestCount();
        testCount.value = 0;

        // 循环从各个点入口开始访问(如果是连通图，则只需要从一个点入口就可以了，而对于非连通图，则有可能存在孤立的点，因此需要各个点都尝试走一遍)
        for (int i = 0; i < pointCount; i++) {
            graphDfs(i, pointCount, graph, isgone, testCount);
        }
        System.out.println("TotalCount:" + testCount.value);
    }

    /**
     * 图的深度优先搜索
     *
     * @param curNode    当前结点索引
     * @param pointCount 图结点总个数
     * @param graph      图的临近矩阵表示
     * @param isgone     图中点是否被访问过
     * @param testCount  测试运行次数
     */
    private static void graphDfs(int curNode, int pointCount, int[][] graph, int[] isgone, TestCount testCount) {
        // 如果当前结点被访问过，则退出(这个判断是为了起始点的访问的，因为下面循环里面有 isgone 的判断，所以在递归过程中下面的判断不成立的)
        if (isgone[curNode] > 0) {
            return;
        }
        // 否则访问，并标识已访问
        System.out.println(curNode);
        isgone[curNode] = 1;
        // 对当前结点的所有临接点进行访问
        for (int i = 0; i < pointCount; i++) {
            testCount.value++;
            // 是临接点，并且没被访问过，则访问
            if (graph[curNode][i] > 0 && isgone[i] == 0) {
                graphDfs(i, pointCount, graph, isgone, testCount);
            }
        }
    }

    public static void graphNoRecurDfs(int pointCount, int[][] graph, int[] isgone) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < pointCount; i++) {
            stack.push(i);
            while (!stack.isEmpty()) {
                int p = stack.pop();
                if (isgone[p] > 0){
                    continue;
                }
                System.out.println(p);
                isgone[p] = 1;
                for (int j = 0; j < pointCount; j++) {
                    if (graph[p][j] > 0 && isgone[j] == 0) {
                        stack.push(j);
                    }
                }
            }
        }
    }

}

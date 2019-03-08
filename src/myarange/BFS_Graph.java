package myarange;

import java.util.LinkedList;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/8/13 下午4:31
 * @Description 算法 tag - [广度搜索]
 *
 * 非连通图的宽度优先搜索实现
 * <p>
 * 下面的 BFS 表示点无向图图的遍历方式，也就是假设有 n 个点，则邻接矩阵 n*n, 则访问过的标识只需要用一维数组就可以表示 isgone[n](由于无向图对称)
 * <p>
 * 我们可以抛弃图，看算法本身，则是处理 n*n 矩阵，遍历矩阵中为 1 的点；
 * <p>
 * 这样，更普遍，计算 m*n 矩阵(1，0分别表示两种情景)，则遍历其中的值为 1 的点；没有图的连接关系了，则需要其他其他关系，比如球场的团簇
 * (有点像扩散法，非递归用队列，递归无)
 * <p>
 * <p>
 * 示例图结构：
 * 0 - 5 - 6 - 4
 * | \
 * 2 3
 * |
 * 1
 * <p>
 * 7
 */

public class BFS_Graph {
    static int pointCount = 8;                              // 图的顶点总个数
    static int[][] graph = new int[pointCount][pointCount]; // 图的二维数组表示
    static int[] isgone = new int[pointCount];              // 点是否被访问过，默认为0，访问过则置1
    static int count = 0;                                   // 计数用

    public static void main(String[] args) {
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
        System.out.println("非递归深度优先搜索："); // 0,2,3,5,1,6,4,7
        BFS_NonRecursive();
    }

    /**
     * /////////////////////////////////////////////////////////////////////////////////////////////////
     * //////////////////////////////////////// 深度遍历(非递归) /////////////////////////////////////////
     * /////////////////////////////////////////////////////////////////////////////////////////////////
     */

    /**
     * 非连通图的宽度优先搜索--非递归
     */
    public static void BFS_NonRecursive() {
        // 队列实现，入 offer , 出 poll()
        LinkedList<Integer> queue = new LinkedList<>();
        // 对每个点都尝试作为入口点进行遍历，主要为防止存在孤立点
        // 因此每次循环前都先判断是否已经被遍历过了，遍历了则不用加入到队列中
        for (int i = 0; i < pointCount; i++) {
            if (isgone[i] == 0) {
                queue.offer(i);
            }
            while (!queue.isEmpty()) {
                // 队列不为空，取出队列头
                int p = queue.poll();
                // 有可能某个点与多个点相连，那么这个点就可能被添加到队列两次，
                // 那在访问过第一次这个点时，则标明已经被访问过了，再访问第二次这个点就错了，因此加了此判断
                if (isgone[p] == 1) {
                    continue;
                }
                // 访问并设置已访问标识 | 用列表存储
                System.out.println(p);
                isgone[p] = 1;
                // 将当前点的所有相连点且未被访问过的，都加入到队列中，以备后续访问。
                for (int j = 0; j < pointCount; j++) {
                    if (graph[p][j] == 1 && isgone[j] == 0) {
                        queue.offer(j);
                    }
                }
            }
        }
    }
}

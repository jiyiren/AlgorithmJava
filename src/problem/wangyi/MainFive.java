package problem.wangyi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/3/27 下午6:43
 * @Description
 */

public class MainFive {
    static class Node {
        int index;
        int val;

        Node(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            Node data[] = new Node[n];
            for (int i = 0; i < n; i++) {
                data[i] = new Node(i + 1, sc.nextInt());
            }
            minStable(n, k, data);
        }
    }

    public static void minStable(int n, int k, Node[] data) {
        Node max = null;
        Node min = null;
        int[] p = new int[n];
        int[] q = new int[n];

        int stable = 0;
        int docount = 0;

        Comparator<Node> comparator = (a, b) -> {
            ////////后加的//////// 也就是说牛客网的编辑器只会自动识别排序好的
            if (a.val == b.val){
                return a.index - b.index;
            }
            ////////后加的////////
            return a.val - b.val;
        };

        while (docount < k) {
            Arrays.sort(data, comparator);
            max = data[n - 1];
            min = data[0];
            if (max.val == min.val || (max.val - min.val) == 1) {
                break;
            }
            max.val--;
            min.val++;

            p[docount] = max.index;
            q[docount] = min.index;
            docount++;
        }
        ////////////////需要计算稳定高度//////////////////////
        Arrays.sort(data, comparator);
        stable = data[n-1].val - data[0].val;
        /////////////////////////////////////////////////

        System.out.println(stable + " " + docount);
        for (int i = 0; i < docount; i++) {
            System.out.print(p[i] + " " + q[i]);
            if (i != docount-1){
                System.out.println();
            }
        }

    }


}

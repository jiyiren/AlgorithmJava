package problem.exercise;

import java.util.*;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/8/22 下午11:21
 * @Description
 */

public class MainOnone {


    static class Pair implements Comparable<Pair> {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            return x == o.x ? o.y - y : x - o.x; //X升序Y降序
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            arr[i] = new Pair(x, y);
        }
        Arrays.sort(arr);
        List<Pair> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean f = true;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (arr[i].x < arr[j].x && arr[i].y < arr[j].y) {
                    f = false;
                    break;
                }
            }
            if (f) {
                res.add(arr[i]);
            }
        }

        Collections.sort(res);
        res.forEach((Pair o) -> System.out.println(o.x + " " + o.y));
        in.close();
    }
}

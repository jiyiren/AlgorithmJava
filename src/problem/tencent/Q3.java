package problem.tencent;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/5 下午10:26
 * @Description
 */

public class Q3 {
    static class Pair {
        int time;
        int level;
        public Pair(int time, int level) {
            this.time = time;
            this.level = level;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Pair[] machine = new Pair[n];
        Pair[] task = new Pair[m];

        // input
        for (int i = 0; i < n; i++)
            machine[i] = new Pair(sc.nextInt(), sc.nextInt());
        for (int i = 0; i < m; i++)
            task[i] = new Pair(sc.nextInt(), sc.nextInt());
        int[] cnt = new int[105];

        // sort
        Comparator<Pair> comparator = (a, b) -> {
            if (a.time == b.time)   return b.level - a.level;
            else return b.time - a.time;
        };
        Arrays.sort(machine, comparator);
        Arrays.sort(task, comparator);

        long sum = 0;

        int j = 0, cnt1 = 0;
        for(int i = 0;i < m;i++) {
            while(j < n && machine[j].time >= task[i].time) {
                  cnt[machine[j].level]++;
                  j++;
            }
            for(int k = task[i].level; k < 101; k++) {
                if(cnt[k] != 0) {
                    cnt[k]--;
                    sum += 200*task[i].time + 3*task[i].level;
                    cnt1++;
                    break;
                }
            }
        }
        System.out.println(cnt1 + " " + sum);
    }
}

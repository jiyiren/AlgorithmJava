package problem.toutiaosecond;

import java.util.*;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/8/25 上午9:22
 * @Description
 */

public class MainOne {

    static int n = 0;
    static List<ArrayList<Integer>> data = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            String line = sc.nextLine();
            String[] arr = line.split("\\s+");
            for (int j = 0; j < arr.length; j++) {
                temp.add(Integer.parseInt(arr[j]));
            }
            data.add(temp);
        }
        solution();
        System.out.println(count);

    }

    static int count = 0;

    public static void solution() {
        int isgone[] = new int[n];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (isgone[i] == 1 || data.get(i).size() == 1) {
                continue;
            }
            queue.offer(i);
            while (!queue.isEmpty()) {
                int index = queue.poll();
                if (isgone[index] == 1) {
                    continue;
                }
                isgone[index] = 1;
                ArrayList<Integer> mtemp = data.get(index);
                for (Integer nu : mtemp) {
                    if (nu == 0 || isgone[nu] == 1) {
                        continue;
                    }
                    queue.offer(nu);
                }
            }

            count++;
        }
    }
}

package problem.exercise;

import java.util.*;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/8/18 下午12:43
 * @Description
 */

public class MainOne {

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N = 0;
    static ArrayList<Pair> pp = new ArrayList<>();
    static ArrayList<Pair> list = new ArrayList<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            N = sc.nextInt();
            for (int i = 0; i < N; i++) {
                Pair p = new Pair(sc.nextInt(), sc.nextInt());
                pp.add(p);
            }
            find();
        }
    }

    static Comparator<Pair> comparator = (a, b) -> {
        if (a.y == b.y) {
            return b.x - a.x;
        }
        return b.y - a.y;
    };

    public static void find() {

        Collections.sort(pp, comparator);
        int maxX = 0;
        for (int i = 0; i < N; i++) {
            Pair curP = pp.get(i);
            if (curP.x > maxX) {
                maxX = curP.x;
                System.out.println(curP.x + " " + curP.y);
            }
        }
//        Collections.sort(list, comparator);
//        for (Pair p :
//                list) {
//            System.out.println(p.x + " " + p.y);
//        }
//        for (int i = list.size() - 1; i >= 0; i--) {
//            Pair p = list.get(i);
//            System.out.println(p.x + " " + p.y);
//        }
    }
}

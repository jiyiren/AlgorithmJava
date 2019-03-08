package problem.toutiao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/8/12 上午9:49
 * @Description
 */

public class MainFour {

    static class Ob{
        long val;
        Ob(long val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            ArrayList<Ob> a = new ArrayList<>();
            ArrayList<Ob> b = new ArrayList<>();

            for (int i = 0; i < num; i++) {
                a.add(new Ob(scanner.nextLong()));
            }
            for (int i = 0; i < num; i++) {
                b.add(new Ob(scanner.nextLong()));
            }

            Iterator<Ob> it = a.iterator();
            Iterator<Ob> itb = b.iterator();
            while (it.hasNext()){
                Ob aa = it.next();
                Ob bb = itb.next();
                if (aa.val>bb.val){
                    it.remove();
                    itb.remove();
                }
            }
            get(num, a, b);

        }
    }

    public static void get(int num, ArrayList<Ob> a, ArrayList<Ob> b) {
        int total = 0;
        for (int i = 0; i < a.size(); i++) {
            for (int j = i; j < a.size(); j++) {
                long amax = Math.max(a.get(i).val, a.get(j).val);
                long bmin = Math.min(b.get(i).val, b.get(j).val);
                if (amax < bmin) {
                    total++;
                }
            }
        }
        System.out.println(total);
    }
}

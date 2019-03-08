package problem.toutiao;

import java.util.*;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/8/12 上午9:49
 * @Description
 */

public class MainTwo {

    static class Pair {
        long first;
        long second;

        public Pair(long first, long second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            String ss = scanner.nextLine();
            ArrayList<String> mydata = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                String li = scanner.nextLine();
                mydata.add(li);
            }
            test(mydata);
        }
    }

    public static void test(ArrayList<String> mydata) {
        ArrayList<Pair> data = new ArrayList<>();
        Comparator<Pair> comparator = (a, b) -> {
            if (a.first > b.first) return 1;
            else return -1;
        };
        // input
        for (int i = 0; i < mydata.size(); i++) {
            String str = mydata.get(i);
            String[] ws = str.split(";");
            for (int j = 0; j < ws.length; j++) {
                String[] da = ws[j].split(",");

                long fir = Long.parseLong(da[0]);
                long sec = Long.parseLong(da[1]);
                if (data.size() == 0) {
                    data.add(new Pair(fir, sec));
                    continue;
                }
                // 查询和替换
                Iterator<Pair> it  = data.iterator();
                while (it.hasNext()) {
                    Pair p = it.next();
                    if (!(p.first > sec || p.second < fir)) {
                        Pair pp = new Pair(Math.min(fir, p.first), Math.max(sec, p.second));
                        it.remove();
//                        data.add(pp);
                        fir = pp.first;
                        sec = pp.second;
                    }
                }
                data.add(new Pair(fir, sec));


            }
        }
        Collections.sort(data, comparator);
        boolean isfirst = true;
        for (Pair p : data) {
            if (!isfirst){
                System.out.print(";");
            }else{
                isfirst = false;
            }
            System.out.print(p.first + "," + p.second);
        }
    }
}

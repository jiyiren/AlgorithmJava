package problem.xiaomi;

import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/10 下午6:58
 * @Description
 */

public class MainOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            System.out.println();
        }
    }

    public synchronized void put() throws InterruptedException {
        int a = 1;
        if(a==0){
            this.wait();
        }
    }
}

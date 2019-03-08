package problem.toutiao;

import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/8/12 上午9:49
 * @Description
 */

public class MainThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int num = scanner.nextInt();
            int[][] data = new int[num][2];
            for (int i=0;i<num;i++){
                data[i][0] = scanner.nextInt();
                data[i][1] = scanner.nextInt();
            }

            for (int i=0;i<num;i++){
                System.out.println(data[i][0]+""+data[i][1]);
            }
        }
    }

    public static void get(int num, int[][] data){
        int total = 0;

    }
}

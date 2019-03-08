package problem.toutiaosecond;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/8/25 上午9:25
 * @Description 3
 * 2
 * helloworld
 * hdlrowolle
 * 2
 * helloworld
 * worldhello
 * 2
 * abcde
 * acbde
 */

public class MainThree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n; i++) {
                int count = Integer.parseInt(sc.nextLine());
                List<String> data = new ArrayList<>();
                for (int j = 0; j < count; j++) {
                    data.add(sc.nextLine());
                }
                System.out.println(fun(data));
            }
        }
    }

    public static String fun(List<String> data) {
        for (int i = 0; i < data.size(); i++) {
            for (int j = i + 1; j < data.size(); j++) {
                if (solution(data.get(i), data.get(j))) {
                    return "Yeah";
                }
            }
        }
        return "Sad";
    }


    public static boolean solution(String a, String b) {
        if (a == null || b == null) {
            return false;
        }
        if (a.length() != b.length()) {
            return false;
        }
        int length = a.length();


        for (int i = 0; i < length; i++) {
            if (a.charAt(0) == b.charAt(i)) {
                return right(a, b, i, length) || left(a, b, i, length);
            }
        }
        return false;
    }

    public static boolean right(String a, String b, int startIndex, int length) {
        for (int i = 0; i < length; i++) {
            if (a.charAt(i) != b.charAt(startIndex)) {
                return false;
            }
            startIndex = (startIndex + 1) % length;
        }
        return true;
    }

    public static boolean left(String a, String b, int startIndex, int length) {
        for (int i = 0; i < length; i++) {
            if (a.charAt(i) != b.charAt(startIndex)) {
                return false;
            }
            if (startIndex == 0) {
                startIndex = length - 1;
            } else {
                startIndex--;
            }
        }
        return true;
    }
}

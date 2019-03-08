package problem.nowcoder;

import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/3/24 下午9:19
 * @Description
 *
 * 字符串反转
 *
 */

public class SentenceReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String line = sc.nextLine();
            System.out.println(sentenceReverse(line));
        }

//        String line = "Hello xiao mi";
//        System.out.println(sentenceReverse(line));
    }

    public static String sentenceReverse(String line){
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for(int i = 0;i<line.length();i++){
            if(line.charAt(i)==' '){
                sb.append(strReverse(line.substring(start,i))+" ");
                start=i+1;
            }
        }
        sb.append(strReverse(line.substring(start,line.length())));

        return strReverse(sb.toString().trim());
    }

    public static String strReverse(String str){
        if(str==""||str==" ")
            return str;
        StringBuilder sb = new StringBuilder();
        for(int i=str.length()-1;i>=0;i--){
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}

package problem.nowcoder;

import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/3/24 上午10:10
 * @Description
 * 题目描述
    给定一个十进制的正整数number，选择从里面去掉一部分数字，希望保留下来的数字组成的正整数最大。
    >>> input:输入为两行内容，第一行是正整数number，1 ≤ length(number) ≤ 50000。第二行是希望去掉的数字数量cnt 1 ≤ cnt < length(number)。
    >>> output:输出保留下来的结果。
    >>>>Example:
        输入 325 1
        输出 35
 */

public class KeepBigNum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String n = sc.nextLine();   //字符串
            int cnt = Integer.parseInt(sc.nextLine()); //移去的数字个数
            System.out.println(getBig(n,cnt));
        }
//        //test
//        String n = "325";   //字符串
//        int cnt = 1; //移去的数字个数
//        System.out.println(getBig(n,cnt));
    }

    /**
     * 思路：从高位开始，每一位的数肯定最大最好。
     *  所以从头查找最大的数。把这个数作为高位，那么这个数就是最大的。
     *  若发现下一位比前一位大，并且需要删除的个数还未满足，则删除前一位，保留当前较大的数，循环
     *
     * @param n
     * @param cnt
     * @return
     */
    public static String getBig(String n, int cnt){
        if(cnt==0){
            return n;
        }
        int length = n.length();
        if(length<=cnt){
            return "0";
        }
        char[] nchars = n.toCharArray();

        StringBuilder sb = new StringBuilder();//最终保留的字符数组
        sb.append(nchars[0]);
        int top = 1; //记录当前字符数
        for (int i=1;i<length;i++){
            while (top>0 && cnt>0 && sb.charAt(top-1)<nchars[i]){
                cnt--;
                sb.deleteCharAt(top-1);
                top--;
            }
            sb.append(nchars[i]);
            top++;
        }
        //如果需要删除的数目不足，则从最后开始删起，知道满足个数
        while (cnt>0){
            sb.deleteCharAt(top-1);
            top--;
            cnt--;
        }

        return sb.toString();
    }


}

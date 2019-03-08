package algorithm.jianzhi;

import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/17 下午3:14
 * @Description
 */

public class Solution {
    public static boolean match(char[] str, char[] pattern)
    {
        if(str==null||pattern==null) return false;

        return matchCore(str,0,pattern,0);
    }

    public static boolean matchCore(char[] str,int s, char[] pattern,int p) {
        if(str.length<=s&&pattern.length<=p)
            return true;//都匹配完了
        if(str.length>s&&pattern.length<=p)
            return false;//模式完了，字符串还有
        //模式串a*a没结束，匹配串可结束可不结束

        if(p+1<pattern.length&&pattern[p+1]=='*'){//当前pattern的下一个是*号时

            //字符串完了
            if(s>=str.length) return matchCore(str, s, pattern, p+2);
            else{

                if(pattern[p]==str[s]||pattern[p]=='.'){
                    //当前位置匹配完成，移动到下一个模式串
                    return matchCore(str,s+1, pattern,p+2)
                            ||matchCore(str,s+1, pattern,p)
                            ||matchCore(str,s, pattern,p+2);
                }else
                    return matchCore(str, s, pattern, p+2);
            }
        }
        //当前pattern的下一个不是*时候
        if(s>=str.length) return false;
        else{
            if(str[s]==pattern[p]||pattern[p]=='.')
                return matchCore(str, s+1, pattern, p+1);
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "ab";
        String pa = ".*c";
        System.out.println(match(str.toCharArray(), pa.toCharArray()));
    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            String st = sc.nextLine();
//            String[] str = st.split(" ");
//            if(match(str[0].toCharArray(), str[1].toCharArray())){
//                System.out.println(1);
//            }else{
//                System.out.println(0);
//            }
//        }
//    }
}

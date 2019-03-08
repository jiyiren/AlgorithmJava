package test;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/8/6 下午2:41
 * @Description
 */

public class MyTe {

    public static void main(String[] args) {
        String[] a = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(a));

    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuffer sb = null;
        int i = 0;
        char temp = 0;
        int flag = 0;
        while (true) {
            flag = 0;
            for (int j = 0; j < strs.length; j++) {
                if (i >= strs[j].length()) {
                    if (sb != null)
                        return sb.toString();
                    else
                        return "";
                }
                char cur = strs[j].charAt(i);
                if (flag == 0) {
                    temp = cur;
                    flag = 1;
                } else {
                    if (temp != cur) {
                        if (sb != null)
                            return sb.toString();
                        else
                            return "";
                    }
                }
            }
            if (sb == null){
                sb = new StringBuffer("");
            }
            sb.append(temp);
            i++;
        }
//        return sb.toString();
    }
}

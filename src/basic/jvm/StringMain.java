package basic.jvm;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/24 上午11:51
 * @Description
 */

public class StringMain {

    public static void main(String[] args) {
//        String str3 = "str01";
        String str2 = new String("str")+new String("01");
        System.out.println(str2.intern()==str2);
        String str1 = "str01";
        System.out.println(str2.intern()==str1);
//        System.out.println(str4==str4.intern());
//        str2.intern();
//        System.out.println(str2==str1);
//        System.out.println(str2.intern()==str1);

//        String s1 = "abc";
//        String s2 = "a";
//        String s3 = "bc";
//        final String s2 = "a";
//        final String s3 = "bc";
//        String s4 = "a" + "bc";
//        System.out.println(s1 == s4);

//        String str1 = "abc";
//        String str2 = new String("abc");
//        System.out.println(str1==str2.intern());
    }
}

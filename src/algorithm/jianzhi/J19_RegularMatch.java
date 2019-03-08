package algorithm.jianzhi;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/17 下午2:26
 * @Description
 *
 * 面试题19：正则表达式匹配
 *
 */

public class J19_RegularMatch {

    public static boolean match(String str, String pattern){
        if(str==null || pattern==null){
            return false;
        }
        return matchCore(str.toCharArray(),pattern.toCharArray(),0,0);
    }
    /**
     * 通过字符数组实现
     * @param str
     * @param pattern
     * @param strIndex
     * @param patternIndex
     * @return
     */
    public static boolean matchCore(char[] str,char[] pattern,int strIndex,int patternIndex){

        if(patternIndex>=pattern.length){
            //模式串结束
            if(strIndex>=str.length){
                return true;
            }else{
                return false;
            }
        }else{
            //模式串未结束，分别对模式串下一个为* 和 非*两种情况讨论
            if(patternIndex<pattern.length-1 && pattern[patternIndex+1]=='*'){
                // 模式串下一个是*
                // ==> 只有在当前字符串索引不越界 且 当前字符相等情况 才进行下一步操作，否则跳过*等2个字符，因为*字符在不匹配情况可以表达0
                if((strIndex<str.length)&&(pattern[patternIndex]=='.' || str[strIndex]==pattern[patternIndex])){
                    // 匹配0个字符 || 匹配1个字符 || 匹配多个字符
                    // 匹配0个字符：模式符跳过当前2个，就相当于没有匹配到(*代表0)
                    // 匹配1个字符：模式符跳过当前2个，同时原字符串也跳一个，代表匹配那个字符
                    // 匹配多个字符：模式符不跳，字符串跳一个，这样模式符可以匹配原字符串下一个(递归匹配多个)
                    return matchCore(str,pattern,strIndex,patternIndex+2) ||
                            matchCore(str,pattern,strIndex+1,patternIndex+2) ||
                            matchCore(str,pattern,strIndex+1,patternIndex);

                }else{
                    return matchCore(str,pattern,strIndex,patternIndex+2);
                }

            }else{
                // 下一个不是*，或者没有下一个
                // ==> 只有在字符串索引不越界 且 当前字符相同才递归下一个字符判断，否则直接不匹配
                if( strIndex<str.length &&(pattern[patternIndex]=='.'||str[strIndex]==pattern[patternIndex])){
                    return matchCore(str,pattern,strIndex+1,patternIndex+1);
                }else{
                    return false;
                }
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(match("a","ab*"));
    }


    /**
     * 通过字符串charAt实现，这个速度相对慢
     * @param str
     * @param pattern
     * @param strIndex
     * @param patternIndex
     * @return
     */
    public static boolean matchCoreStr(String str,String pattern,int strIndex,int patternIndex){

        if(patternIndex>=pattern.length()){
            if(strIndex>=str.length()){
                return true;
            }else{
                return false;
            }
        }else{
            //模式串未结束
            if(patternIndex<pattern.length()-1 && pattern.charAt(patternIndex+1)=='*'){
                // 模式串下一个是*
                // ==> 只有在当前字符串索引不越界 且 当前字符相等情况 才进行下一步操作，否则跳过*等2个字符，因为*字符在不匹配情况可以表达0
                if((strIndex<str.length())&&(pattern.charAt(patternIndex)=='.' || str.charAt(strIndex)==pattern.charAt(patternIndex))){
                    // 匹配0个字符 || 匹配1个字符 || 匹配多个字符
                    // 匹配0个字符：模式符跳过当前2个，就相当于没有匹配到(*代表0)
                    // 匹配1个字符：模式符跳过当前2个，同时原字符串也跳一个，代表匹配那个字符
                    // 匹配多个字符：模式符不跳，字符串跳一个，这样模式符可以匹配原字符串下一个(递归匹配多个)
                    return matchCoreStr(str,pattern,strIndex,patternIndex+2) ||
                            matchCoreStr(str,pattern,strIndex+1,patternIndex+2) ||
                            matchCoreStr(str,pattern,strIndex+1,patternIndex);

                }else{
                    return matchCoreStr(str,pattern,strIndex,patternIndex+2);
                }

            }else{
                // 下一个不是*，或者没有下一个
                // ==> 只有在字符串索引不越界 且 当前字符相同才递归下一个字符判断，否则直接不匹配
                if( strIndex<str.length() &&(pattern.charAt(patternIndex)=='.'||str.charAt(strIndex)==pattern.charAt(patternIndex))){
                    return matchCoreStr(str,pattern,strIndex+1,patternIndex+1);
                }else{
                    return false;
                }
            }
        }

    }
}

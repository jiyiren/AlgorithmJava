package algorithm.jianzhi;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/13 下午2:46
 * @Description
 *
 * 面试题5：替换空格
 *
 */

public class J05_ReplaceSpace {

    /**
     *
     * 先一层遍历，计算空格的数目，并计算新数组的位置O(n)
     * 再一层遍历，从后移到适合的位置O(n)
     *
     * 时间复杂度：O(2n)=O(n),空间复杂度O(1)
     *
     * 这里用!代替C++中的\0
     * @param str    字符数组
     * @param length 为字符数组的总容量
     * @return
     */
    public static char[] replaceSpace(char[] str,int length){
        if(str==null || length<=0){
            return null;
        }

        //计算空格个数
        int originArrCount = 0;
        int spaceCount = 0;
        int i=0;
        while (str[i++]!='!'){
            if(str[i]==' '){
                spaceCount++;
            }
            originArrCount++;
        }
        originArrCount++;//将!也计算在内

        // 分别从新数最后一位和旧数组最后一位开始
        int oldEndIndex = originArrCount-1;
        int newEndIndex = originArrCount+2*spaceCount-1;
        if(newEndIndex+1>length){
            return null;
        }

        while (oldEndIndex>=0 && oldEndIndex < newEndIndex){
            if(str[oldEndIndex]!=' '){
                str[newEndIndex--]=str[oldEndIndex--];
            }else {
                oldEndIndex--;
                str[newEndIndex--]='0';
                str[newEndIndex--]='2';
                str[newEndIndex--]='%';
            }
        }

        return str;
    }

    public static void main(String[] args) {
        char[] str = new char[100];
        String mstr = "We are happy!";
        char[] mstrarr = mstr.toCharArray();
        for(int i=0;i<mstrarr.length;i++){
            str[i]=mstrarr[i];
        }
        System.out.println(str);
        System.out.println(replaceSpace(str,100));
    }
}
